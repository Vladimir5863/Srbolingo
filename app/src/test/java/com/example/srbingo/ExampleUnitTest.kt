package com.example.srbingo

import com.example.srbingo.model.Question
import com.example.srbingo.model.UserProgress
import org.junit.Test
import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun userProgress_canAccessLevel_isCorrect() {
        val userProgress = UserProgress(userId = "test", completedLevels = 3)
        
        // Level 1 should always be accessible
        assertTrue(userProgress.canAccessLevel(1))
        
        // Can access completed levels
        assertTrue(userProgress.canAccessLevel(2))
        assertTrue(userProgress.canAccessLevel(3))
        
        // Can access next level after completed
        assertTrue(userProgress.canAccessLevel(4))
        
        // Cannot access levels beyond next available
        assertFalse(userProgress.canAccessLevel(5))
        assertFalse(userProgress.canAccessLevel(6))
    }

    @Test
    fun question_defaultValues_areCorrect() {
        val question = Question()
        
        assertEquals("", question.questionText)
        assertTrue(question.options.isEmpty())
        assertEquals("", question.correctAnswer)
        assertEquals(1, question.level)
    }

    @Test
    fun question_customValues_areCorrect() {
        val question = Question(
            questionText = "What is 2+2?",
            options = listOf("3", "4", "5", "6"),
            correctAnswer = "4",
            level = 2
        )
        
        assertEquals("What is 2+2?", question.questionText)
        assertEquals(4, question.options.size)
        assertTrue(question.options.contains("4"))
        assertEquals("4", question.correctAnswer)
        assertEquals(2, question.level)
    }

    @Test
    fun userProgress_defaultValues_areCorrect() {
        val progress = UserProgress()
        
        assertEquals("", progress.userId)
        assertEquals(0, progress.completedLevels)
    }

    @Test
    fun userProgress_customValues_areCorrect() {
        val progress = UserProgress("user123", 5)
        
        assertEquals("user123", progress.userId)
        assertEquals(5, progress.completedLevels)
    }
}