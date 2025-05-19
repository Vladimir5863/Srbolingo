package com.example.srbingo

import com.example.srbingo.model.Question
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class QuestionManagerTest {
    private lateinit var question1: Question
    private lateinit var question2: Question
    private lateinit var question3: Question

    @Before
    fun setup() {
        question1 = Question(
            questionText = "What is the translation of 'Hello'?",
            options = listOf("Zdravo", "Doviđenja", "Molim", "Hvala"),
            correctAnswer = "Zdravo",
            level = 1
        )
        
        question2 = Question(
            questionText = "What is the translation of 'Goodbye'?",
            options = listOf("Zdravo", "Doviđenja", "Molim", "Hvala"),
            correctAnswer = "Doviđenja",
            level = 1
        )
        
        question3 = Question(
            questionText = "What is the translation of 'Please'?",
            options = listOf("Zdravo", "Doviđenja", "Molim", "Hvala"),
            correctAnswer = "Molim",
            level = 2
        )
    }

    @Test
    fun `test question creation`() {
        assertNotNull(question1)
        assertEquals("What is the translation of 'Hello'?", question1.questionText)
        assertEquals(4, question1.options.size)
        assertEquals("Zdravo", question1.correctAnswer)
        assertEquals(1, question1.level)
    }

    @Test
    fun `test question options contain correct answer`() {
        assertTrue(question1.options.contains(question1.correctAnswer))
        assertTrue(question2.options.contains(question2.correctAnswer))
        assertTrue(question3.options.contains(question3.correctAnswer))
    }

    @Test
    fun `test question level validation`() {
        assertTrue(question1.level in 1..10)
        assertTrue(question2.level in 1..10)
        assertTrue(question3.level in 1..10)
    }

    @Test
    fun `test question filtering by level`() {
        val allQuestions = listOf(question1, question2, question3)
        val level1Questions = allQuestions.filter { it.level == 1 }
        
        assertEquals(2, level1Questions.size)
        assertTrue(level1Questions.all { it.level == 1 })
        assertTrue(level1Questions.contains(question1))
        assertTrue(level1Questions.contains(question2))
    }
} 