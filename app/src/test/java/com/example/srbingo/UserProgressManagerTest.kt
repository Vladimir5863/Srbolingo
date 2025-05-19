package com.example.srbingo

import com.example.srbingo.model.UserProgress
import org.junit.Test
import org.junit.Assert.*

class UserProgressManagerTest {
    @Test
    fun `test level progression logic`() {
        val progress = UserProgress("user1", completedLevels = 3)
        
        // Can access completed levels
        assertTrue(progress.canAccessLevel(1))
        assertTrue(progress.canAccessLevel(2))
        assertTrue(progress.canAccessLevel(3))
        
        // Can access next level
        assertTrue(progress.canAccessLevel(4))
        
        // Cannot access future levels
        assertFalse(progress.canAccessLevel(5))
        assertFalse(progress.canAccessLevel(10))
    }

    @Test
    fun `test first level always accessible`() {
        val progress = UserProgress("user1", completedLevels = 0)
        assertTrue(progress.canAccessLevel(1))
    }

    @Test
    fun `test user progress initialization`() {
        val progress = UserProgress("testUser", 0)
        assertEquals("testUser", progress.userId)
        assertEquals(0, progress.completedLevels)
    }

    @Test
    fun `test level access with different progress states`() {
        // Test with no completed levels
        val progress0 = UserProgress("user1", 0)
        assertTrue(progress0.canAccessLevel(1))
        assertFalse(progress0.canAccessLevel(2))
        
        // Test with one completed level
        val progress1 = UserProgress("user1", 1)
        assertTrue(progress1.canAccessLevel(1))
        assertTrue(progress1.canAccessLevel(2))
        assertFalse(progress1.canAccessLevel(3))
        
        // Test with multiple completed levels
        val progress5 = UserProgress("user1", 5)
        assertTrue(progress5.canAccessLevel(1))
        assertTrue(progress5.canAccessLevel(2))
        assertTrue(progress5.canAccessLevel(3))
        assertTrue(progress5.canAccessLevel(4))
        assertTrue(progress5.canAccessLevel(5))
        assertTrue(progress5.canAccessLevel(6))
        assertFalse(progress5.canAccessLevel(7))
    }
} 