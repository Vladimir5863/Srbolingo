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
import com.example.srbingo.databinding.ActivityLoginBinding
import com.example.srbingo.utils.MusicManager
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkObject
import io.mockk.mockkStatic
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.junit.Assert.*

// Test klasa za LoginActivity
@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class LoginActivityTest {
    // Inicijalizacija potrebnih varijabli
    private lateinit var context: Context // Kontekst aplikacije
    private lateinit var auth: FirebaseAuth // Firebase autentifikacija
    private lateinit var musicManager: MusicManager // Upravljanje muzikom
    private lateinit var binding: ActivityLoginBinding // Povezivanje sa XML layoutom
    private lateinit var loginActivity: LoginActivity // Aktivnost za prijavu
    private lateinit var loginButton: Button
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText

    // Postavljanje testnog okruženja pre svakog testa
    @Before
    fun setup() {
        context = ApplicationProvider.getApplicationContext()
        
        // Kreiranje mock objekta za Firebase Auth
        auth = mockk(relaxed = true)
        mockkStatic(FirebaseAuth::class)
        every { FirebaseAuth.getInstance() } returns auth
        
        // Kreiranje mock objekta za MusicManager
        musicManager = mockk(relaxed = true)
        mockkObject(MusicManager.Companion)
        every { MusicManager.getInstance(any()) } returns musicManager
        
        // Kreiranje mock objekta za Toast poruke
        mockkStatic(Toast::class)
        every { Toast.makeText(any(), any<String>(), any()) } returns mockk()
        
        // Kreiranje mock objekta za Intent
        mockkStatic(Intent::class)
        every { Intent(any<Context>(), any<Class<*>>()) } returns mockk()
        
        // Kreiranje mock objekta za binding
        binding = mockk(relaxed = true)
        
        // Kreiranje instance aktivnosti
        loginActivity = LoginActivity()
        
        // Mock EditText fields
        emailEditText = mockk(relaxed = true)
        passwordEditText = mockk(relaxed = true)
        every { binding.emailEditText } returns emailEditText
        every { binding.passwordEditText } returns passwordEditText
        
        // Mock Login Button
        loginButton = mockk(relaxed = true)
        every { binding.loginButton } returns loginButton
        
        // Set up click listener
        every { loginButton.setOnClickListener(any()) } answers {
            val listener = firstArg<View.OnClickListener>()
            listener.onClick(loginButton)
            Unit
        }
        
        // Set the binding to the activity using reflection
        val bindingField = LoginActivity::class.java.getDeclaredField("binding")
        bindingField.isAccessible = true
        bindingField.set(loginActivity, binding)
    }

    // Test za prijavu sa praznim poljima
    @Test
    fun `test login with empty fields shows error`() {
        // Postavljanje praznih polja
        every { emailEditText.text.toString() } returns ""
        every { passwordEditText.text.toString() } returns ""
        
        // Simulacija klika na dugme za prijavu
        val clickListener = mockk<View.OnClickListener>()
        every { clickListener.onClick(any()) } returns Unit
        loginButton.setOnClickListener(clickListener)
        
        // Provera da li je prikazana poruka o grešci
        verify { Toast.makeText(any(), "Please fill all fields", Toast.LENGTH_SHORT) }
    }

    // Test za uspešnu prijavu sa validnim kredencijalima
    @Test
    fun `test login with valid credentials navigates to main activity`() {
        // Postavljanje validnih kredencijala
        val email = "test@example.com"
        val password = "password123"
        val firebaseUser = mockk<FirebaseUser>()
        val authResult = mockk<AuthResult>()
        
        every { emailEditText.text.toString() } returns email
        every { passwordEditText.text.toString() } returns password
        every { authResult.user } returns firebaseUser
        
        // Simulacija uspešne prijave
        val task = mockk<Task<AuthResult>>()
        every { task.isSuccessful } returns true
        every { task.result } returns authResult
        every { auth.signInWithEmailAndPassword(email, password) } returns task
        every { task.addOnCompleteListener(any<Activity>(), any()) } answers {
            val listener = secondArg<com.google.android.gms.tasks.OnCompleteListener<AuthResult>>()
            listener.onComplete(task)
            task
        }
        
        // Simulacija klika na dugme za prijavu
        val clickListener = mockk<View.OnClickListener>()
        every { clickListener.onClick(any()) } returns Unit
        loginButton.setOnClickListener(clickListener)
        
        // Provera da li je korisnik preusmeren na glavni ekran
        verify { Intent(any(), MainActivity::class.java) }
    }

    // Test za neuspešnu prijavu sa nevalidnim kredencijalima
    @Test
    fun `test login with invalid credentials shows error`() {
        // Postavljanje nevalidnih kredencijala
        val email = "test@example.com"
        val password = "wrongpassword"
        val exception = mockk<Exception>()
        
        every { emailEditText.text.toString() } returns email
        every { passwordEditText.text.toString() } returns password
        every { exception.message } returns "Invalid credentials"
        
        // Simulacija neuspešne prijave
        val task = mockk<Task<AuthResult>>()
        every { task.isSuccessful } returns false
        every { task.exception } returns exception
        every { auth.signInWithEmailAndPassword(email, password) } returns task
        every { task.addOnCompleteListener(any<Activity>(), any()) } answers {
            val listener = secondArg<com.google.android.gms.tasks.OnCompleteListener<AuthResult>>()
            listener.onComplete(task)
            task
        }
        
        // Simulacija klika na dugme za prijavu
        val clickListener = mockk<View.OnClickListener>()
        every { clickListener.onClick(any()) } returns Unit
        loginButton.setOnClickListener(clickListener)
        
        // Provera da li je prikazana poruka o grešci
        verify { Toast.makeText(any(), "Authentication failed: Invalid credentials", Toast.LENGTH_SHORT) }
    }

    // Test za navigaciju na ekran za registraciju
    @Test
    fun `test register button navigates to register activity`() {
        // Simulacija klika na dugme za registraciju
        val clickListener = mockk<View.OnClickListener>()
        every { clickListener.onClick(any()) } returns Unit
        binding.registerButton.setOnClickListener(clickListener)
        
        // Provera da li je korisnik preusmeren na ekran za registraciju
        verify { Intent(any(), RegisterActivity::class.java) }
    }
} 