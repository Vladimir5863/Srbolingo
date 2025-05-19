package com.example.srbingo

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import io.mockk.every
import io.mockk.mockk
import org.junit.Test

class TestMockk {

    val mockAuth = mockk<FirebaseAuth>(relaxed = true)
    val mockTask = mockk<Task<AuthResult>>(relaxed = true) as Task<AuthResult>

    @Test
    fun testLoginSuccesful(){
        every { mockTask.isSuccessful } returns true
        every { mockAuth.signInWithEmailAndPassword(" ", " ") } returns mockTask

        mockAuth.signInWithEmailAndPassword(" "," ").addOnCompleteListener{task-> assert(task.isSuccessful)}
    }

    @Test
    fun testLoginFailed(){
        every { mockTask.isSuccessful } returns false
        every { mockAuth.signInWithEmailAndPassword("wrong@example.com", "wrongpassword") } returns mockTask

        mockAuth.signInWithEmailAndPassword("wrong@example.com","wrongpassword").addOnCompleteListener{task-> assert(!task.isSuccessful)}
    }
} 