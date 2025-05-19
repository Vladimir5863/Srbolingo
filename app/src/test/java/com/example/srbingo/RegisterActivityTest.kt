package com.example.srbingo

// Potrebni importi za testiranje
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.srbingo.databinding.ActivityRegisterBinding
import com.example.srbingo.utils.MusicManager
import com.google.firebase.auth.FirebaseAuth
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkObject
import io.mockk.mockkStatic
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

// Test klasa za RegisterActivity
@RunWith(AndroidJUnit4::class)
class RegisterActivityTest {
    // Inicijalizacija potrebnih varijabli
    private lateinit var context: Context // Kontekst aplikacije
    private lateinit var auth: FirebaseAuth // Firebase autentifikacija
    private lateinit var musicManager: MusicManager // Upravljanje muzikom
    private lateinit var binding: ActivityRegisterBinding // Povezivanje sa XML layoutom
    private lateinit var registerActivity: RegisterActivity // Aktivnost za registraciju
    private lateinit var registerButton: Button
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText

    // Postavljanje testnog okruženja pre svakog testa
    @Before
    fun setup() {
        context = ApplicationProvider.getApplicationContext()
        
        // Mock Firebase Auth
        auth = mockk(relaxed = true)
        mockkStatic(FirebaseAuth::class)
        every { FirebaseAuth.getInstance() } returns auth
        
        // Mock MusicManager
        musicManager = mockk(relaxed = true)
        mockkObject(MusicManager.Companion)
        every { MusicManager.getInstance(any()) } returns musicManager
        
        // Mock Toast
        mockkStatic(Toast::class)
        every { Toast.makeText(any(), any<String>(), any()) } returns mockk()
        
        // Mock Intent
        mockkStatic(Intent::class)
        every { Intent(any<Context>(), any<Class<*>>()) } returns mockk()
        
        // Create activity instance
        registerActivity = RegisterActivity()
        
        // Mock binding and its views
        binding = mockk(relaxed = true)
        
        // Mock EditText fields
        emailEditText = mockk(relaxed = true)
        passwordEditText = mockk(relaxed = true)
        confirmPasswordEditText = mockk(relaxed = true)
        every { binding.emailEditText } returns emailEditText
        every { binding.passwordEditText } returns passwordEditText
        every { binding.confirmPasswordEditText } returns confirmPasswordEditText
        
        // Mock Register Button
        registerButton = mockk(relaxed = true)
        every { binding.registerButton } returns registerButton
        
        // Set up click listener
        every { registerButton.setOnClickListener(any()) } answers {
            val listener = firstArg<View.OnClickListener>()
            listener.onClick(registerButton)
            Unit
        }
        
        // Set the binding to the activity using reflection
        val bindingField = RegisterActivity::class.java.getDeclaredField("binding")
        bindingField.isAccessible = true
        bindingField.set(registerActivity, binding)
    }

    // Test za registraciju sa praznim poljima
    @Test
    fun `test register with empty fields shows error`() {
        // Setup empty fields
        every { emailEditText.text.toString() } returns ""
        every { passwordEditText.text.toString() } returns ""
        every { confirmPasswordEditText.text.toString() } returns ""
        
        // Simulate register button click
        val clickListener = mockk<View.OnClickListener>()
        every { clickListener.onClick(any()) } returns Unit
        registerButton.setOnClickListener(clickListener)
        
        // Verify error message
        verify { Toast.makeText(any(), "Please fill all fields", Toast.LENGTH_SHORT) }
    }

    // Test za registraciju sa neusklađenim lozinkama
    @Test
    fun `test register with non matching passwords shows error`() {
        // Setup non matching passwords
        every { emailEditText.text.toString() } returns "test@example.com"
        every { passwordEditText.text.toString() } returns "password123"
        every { confirmPasswordEditText.text.toString() } returns "password456"
        
        // Simulate register button click
        val clickListener = mockk<View.OnClickListener>()
        every { clickListener.onClick(any()) } returns Unit
        registerButton.setOnClickListener(clickListener)
        
        // Verify error message
        verify { Toast.makeText(any(), "Passwords do not match", Toast.LENGTH_SHORT) }
    }

    // Test za uspešnu registraciju sa validnim kredencijalima
    @Test
    fun `test register with valid credentials navigates to main activity`() {
        // Setup valid credentials
        val email = "test@example.com"
        val password = "password123"
        
        every { emailEditText.text.toString() } returns email
        every { passwordEditText.text.toString() } returns password
        every { confirmPasswordEditText.text.toString() } returns password
        
        // Mock successful registration
        val task = mockk<com.google.android.gms.tasks.Task<com.google.firebase.auth.AuthResult>>()
        every { task.isSuccessful } returns true
        every { auth.createUserWithEmailAndPassword(email, password) } returns task
        every { task.addOnCompleteListener(any<Activity>(), any<com.google.android.gms.tasks.OnCompleteListener<com.google.firebase.auth.AuthResult>>()) } answers {
            val listener = secondArg<com.google.android.gms.tasks.OnCompleteListener<com.google.firebase.auth.AuthResult>>()
            listener.onComplete(task)
            task
        }
        
        // Simulate register button click
        val clickListener = mockk<View.OnClickListener>()
        every { clickListener.onClick(any()) } returns Unit
        registerButton.setOnClickListener(clickListener)
        
        // Verify navigation to main activity
        verify { Intent(any(), MainActivity::class.java) }
    }

    // Test za registraciju sa nevalidnom email adresom
    @Test
    fun `test register with invalid email shows error`() {
        // Setup invalid email
        val email = "invalid-email"
        val password = "password123"
        val exception = mockk<Exception>()
        
        every { emailEditText.text.toString() } returns email
        every { passwordEditText.text.toString() } returns password
        every { confirmPasswordEditText.text.toString() } returns password
        every { exception.message } returns "The email address is badly formatted"
        
        // Mock failed registration
        val task = mockk<com.google.android.gms.tasks.Task<com.google.firebase.auth.AuthResult>>()
        every { task.isSuccessful } returns false
        every { task.exception } returns exception
        every { auth.createUserWithEmailAndPassword(email, password) } returns task
        every { task.addOnCompleteListener(any<Activity>(), any<com.google.android.gms.tasks.OnCompleteListener<com.google.firebase.auth.AuthResult>>()) } answers {
            val listener = secondArg<com.google.android.gms.tasks.OnCompleteListener<com.google.firebase.auth.AuthResult>>()
            listener.onComplete(task)
            task
        }
        
        // Simulate register button click
        val clickListener = mockk<View.OnClickListener>()
        every { clickListener.onClick(any()) } returns Unit
        registerButton.setOnClickListener(clickListener)
        
        // Verify error message
        verify { Toast.makeText(any(), "Registration failed: The email address is badly formatted", Toast.LENGTH_SHORT) }
    }

    // Test za registraciju sa slabom lozinkom
    @Test
    fun `test register with weak password shows error`() {
        // Setup weak password
        val email = "test@example.com"
        val password = "123" // Too short password
        val exception = mockk<Exception>()
        
        every { emailEditText.text.toString() } returns email
        every { passwordEditText.text.toString() } returns password
        every { confirmPasswordEditText.text.toString() } returns password
        every { exception.message } returns "Password should be at least 6 characters"
        
        // Mock failed registration
        val task = mockk<com.google.android.gms.tasks.Task<com.google.firebase.auth.AuthResult>>()
        every { task.isSuccessful } returns false
        every { task.exception } returns exception
        every { auth.createUserWithEmailAndPassword(email, password) } returns task
        every { task.addOnCompleteListener(any<Activity>(), any<com.google.android.gms.tasks.OnCompleteListener<com.google.firebase.auth.AuthResult>>()) } answers {
            val listener = secondArg<com.google.android.gms.tasks.OnCompleteListener<com.google.firebase.auth.AuthResult>>()
            listener.onComplete(task)
            task
        }
        
        // Simulate register button click
        val clickListener = mockk<View.OnClickListener>()
        every { clickListener.onClick(any()) } returns Unit
        registerButton.setOnClickListener(clickListener)
        
        // Verify error message
        verify { Toast.makeText(any(), "Registration failed: Password should be at least 6 characters", Toast.LENGTH_SHORT) }
    }
} 