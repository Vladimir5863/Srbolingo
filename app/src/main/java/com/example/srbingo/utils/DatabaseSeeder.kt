package com.example.srbingo.utils

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

object DatabaseSeeder {
    private val db = FirebaseFirestore.getInstance()

    fun seedQuestions() {
        val questions = listOf(
            mapOf(
                "correctAnswer" to "eat",
                "level" to 6,
                "options" to listOf("eat", "am eating", "ate", "was eating"),
                "questionText" to "I ___ lunch at 12 PM every day."
            ),
            mapOf(
                "correctAnswer" to "was watching",
                "level" to 6,
                "options" to listOf("watch", "am watching", "watched", "was watching"),
                "questionText" to "I ___ TV when the phone rang."
            ),
            mapOf(
                "correctAnswer" to "am playing",
                "level" to 6,
                "options" to listOf("play", "am playing", "played", "was playing"),
                "questionText" to "I ___ basketball with my friends right now."
            ),
            mapOf(
                "correctAnswer" to "played",
                "level" to 6,
                "options" to listOf("play", "am playing", "played", "was playing"),
                "questionText" to "I ___ tennis yesterday afternoon."
            ),
            mapOf(
                "correctAnswer" to "am studying",
                "level" to 6,
                "options" to listOf("study", "am studying", "studied", "was studying"),
                "questionText" to "I ___ for my exam at the moment."
            ),
            mapOf(
                "correctAnswer" to "studied",
                "level" to 6,
                "options" to listOf("study", "am studying", "studied", "was studying"),
                "questionText" to "I ___ for the test last night."
            ),
            mapOf(
                "correctAnswer" to "was reading",
                "level" to 6,
                "options" to listOf("read", "am reading", "read", "was reading"),
                "questionText" to "I ___ a book when you called me."
            ),
            mapOf(
                "correctAnswer" to "am working",
                "level" to 6,
                "options" to listOf("work", "am working", "worked", "was working"),
                "questionText" to "I ___ on my project right now."
            ),
            mapOf(
                "correctAnswer" to "worked",
                "level" to 6,
                "options" to listOf("work", "am working", "worked", "was working"),
                "questionText" to "I ___ on a big project last week."
            ),
            mapOf(
                "correctAnswer" to "am cooking",
                "level" to 6,
                "options" to listOf("cook", "am cooking", "cooked", "was cooking"),
                "questionText" to "I ___ dinner at the moment."
            ),
            mapOf(
                "correctAnswer" to "was cooking",
                "level" to 6,
                "options" to listOf("cook", "am cooking", "cooked", "was cooking"),
                "questionText" to "I ___ dinner when the doorbell rang."
            ),
            mapOf(
                "correctAnswer" to "cooked",
                "level" to 6,
                "options" to listOf("cook", "am cooking", "cooked", "was cooking"),
                "questionText" to "I ___ a big meal for my family yesterday."
            ),
            mapOf(
                "correctAnswer" to "write",
                "level" to 6,
                "options" to listOf("write", "am writing", "wrote", "was writing"),
                "questionText" to "I ___ letters to my friends every weekend."
            ),
            mapOf(
                "correctAnswer" to "wrote",
                "level" to 6,
                "options" to listOf("write", "am writing", "wrote", "was writing"),
                "questionText" to "I ___ a letter to my friend yesterday."
            ),
            mapOf(
                "correctAnswer" to "was writing",
                "level" to 6,
                "options" to listOf("write", "am writing", "wrote", "was writing"),
                "questionText" to "I ___ an email when the power went out."
            ),
            mapOf(
                "correctAnswer" to "run",
                "level" to 6,
                "options" to listOf("run", "am running", "ran", "was running"),
                "questionText" to "I ___ five kilometers every morning."
            ),
            mapOf(
                "correctAnswer" to "am running",
                "level" to 6,
                "options" to listOf("run", "am running", "ran", "was running"),
                "questionText" to "I ___ in the park right now."
            ),
            mapOf(
                "correctAnswer" to "ran",
                "level" to 6,
                "options" to listOf("run", "am running", "ran", "was running"),
                "questionText" to "I ___ to catch the bus yesterday."
            ),
            mapOf(
                "correctAnswer" to "was running",
                "level" to 6,
                "options" to listOf("run", "am running", "ran", "was running"),
                "questionText" to "I ___ when I tripped over a rock."
            ),
            mapOf(
                "correctAnswer" to "travel",
                "level" to 6,
                "options" to listOf("travel", "am traveling", "traveled", "was traveling"),
                "questionText" to "I ___ to different countries every summer."
            ),
            mapOf(
                "correctAnswer" to "am traveling",
                "level" to 6,
                "options" to listOf("travel", "am traveling", "traveled", "was traveling"),
                "questionText" to "I ___ to Spain at the moment."
            ),
            mapOf(
                "correctAnswer" to "traveled",
                "level" to 6,
                "options" to listOf("travel", "am traveling", "traveled", "was traveling"),
                "questionText" to "I ___ to France last year."
            ),
            mapOf(
                "correctAnswer" to "was traveling",
                "level" to 6,
                "options" to listOf("travel", "am traveling", "traveled", "was traveling"),
                "questionText" to "I ___ through Italy when I lost my passport."
            ),
            mapOf(
                "correctAnswer" to "read",
                "level" to 6,
                "options" to listOf("read", "am reading", "read (past)", "was reading"),
                "questionText" to "I ___ books every evening before bed."
            ),
            mapOf(
                "correctAnswer" to "am reading",
                "level" to 6,
                "options" to listOf("read", "am reading", "read (past)", "was reading"),
                "questionText" to "I ___ a very interesting novel right now."
            ),
            mapOf(
                "correctAnswer" to "read (past)",
                "level" to 6,
                "options" to listOf("read", "am reading", "read (past)", "was reading"),
                "questionText" to "I ___ a fantastic book last month."
            ),
            mapOf(
                "correctAnswer" to "was reading",
                "level" to 6,
                "options" to listOf("read", "am reading", "read (past)", "was reading"),
                "questionText" to "I ___ a magazine when you entered the room."
            ),
            mapOf(
                "correctAnswer" to "listen",
                "level" to 6,
                "options" to listOf("listen", "am listening", "listened", "was listening"),
                "questionText" to "I ___ to music every evening."
            ),
            mapOf(
                "correctAnswer" to "am listening",
                "level" to 6,
                "options" to listOf("listen", "am listening", "listened", "was listening"),
                "questionText" to "I ___ to a podcast right now."
            ),
            mapOf(
                "correctAnswer" to "listened",
                "level" to 6,
                "options" to listOf("listen", "am listening", "listened", "was listening"),
                "questionText" to "I ___ to a great album yesterday."
            ),
            mapOf(
                "correctAnswer" to "was listening",
                "level" to 6,
                "options" to listOf("listen", "am listening", "listened", "was listening"),
                "questionText" to "I ___ to music when the power went out."
            ),
            mapOf(
                "correctAnswer" to "swim",
                "level" to 6,
                "options" to listOf("swim", "am swimming", "swam", "was swimming"),
                "questionText" to "I ___ in the pool every Saturday."
            ),
            mapOf(
                "correctAnswer" to "am swimming",
                "level" to 6,
                "options" to listOf("swim", "am swimming", "swam", "was swimming"),
                "questionText" to "I ___ in the lake right now."
            ),
            mapOf(
                "correctAnswer" to "swam",
                "level" to 6,
                "options" to listOf("swim", "am swimming", "swam", "was swimming"),
                "questionText" to "I ___ in the ocean during my vacation."
            ),
            mapOf(
                "correctAnswer" to "was swimming",
                "level" to 6,
                "options" to listOf("swim", "am swimming", "swam", "was swimming"),
                "questionText" to "I ___ when it started to rain."
            ),
            mapOf(
                "correctAnswer" to "build",
                "level" to 6,
                "options" to listOf("build", "am building", "built", "was building"),
                "questionText" to "I ___ sandcastles whenever I go to the beach."
            ),
            mapOf(
                "correctAnswer" to "am building",
                "level" to 6,
                "options" to listOf("build", "am building", "built", "was building"),
                "questionText" to "I ___ a treehouse right now."
            ),
            mapOf(
                "correctAnswer" to "built",
                "level" to 6,
                "options" to listOf("build", "am building", "built", "was building"),
                "questionText" to "I ___ a birdhouse last weekend."
            ),
            mapOf(
                "correctAnswer" to "was building",
                "level" to 6,
                "options" to listOf("build", "am building", "built", "was building"),
                "questionText" to "I ___ a fort when it collapsed."
            ),
            mapOf(
                "correctAnswer" to "teach",
                "level" to 6,
                "options" to listOf("teach", "am teaching", "taught", "was teaching"),
                "questionText" to "I ___ math to kids every summer."
            ),
            mapOf(
                "correctAnswer" to "am teaching",
                "level" to 6,
                "options" to listOf("teach", "am teaching", "taught", "was teaching"),
                "questionText" to "I ___ English to a new student right now."
            ),
            mapOf(
                "correctAnswer" to "taught",
                "level" to 6,
                "options" to listOf("teach", "am teaching", "taught", "was teaching"),
                "questionText" to "I ___ history in high school last year."
            ),
            mapOf(
                "correctAnswer" to "was teaching",
                "level" to 6,
                "options" to listOf("teach", "am teaching", "taught", "was teaching"),
                "questionText" to "I ___ science when the principal entered the classroom."
            ),
            mapOf(
                "correctAnswer" to "drive",
                "level" to 6,
                "options" to listOf("drive", "am driving", "drove", "was driving"),
                "questionText" to "I ___ to work every day."
            ),
            mapOf(
                "correctAnswer" to "am driving",
                "level" to 6,
                "options" to listOf("drive", "am driving", "drove", "was driving"),
                "questionText" to "I ___ to the store right now."
            ),
            mapOf(
                "correctAnswer" to "drove",
                "level" to 6,
                "options" to listOf("drive", "am driving", "drove", "was driving"),
                "questionText" to "I ___ to the mountains last weekend."
            ),
            mapOf(
                "correctAnswer" to "was driving",
                "level" to 6,
                "options" to listOf("drive", "am driving", "drove", "was driving"),
                "questionText" to "I ___ when I saw a deer on the road."
            ),
            mapOf(
                "correctAnswer" to "will travel",
                "level" to 7,
                "options" to listOf("will travel", "am traveling", "am going to travel", "travel"),
                "questionText" to "I ___ to Italy next summer."
            ),
            mapOf(
                "correctAnswer" to "am going to study",
                "level" to 7,
                "options" to listOf("will study", "am studying", "am going to study", "study"),
                "questionText" to "I ___ for my exams this weekend."
            ),
            mapOf(
                "correctAnswer" to "am meeting",
                "level" to 7,
                "options" to listOf("will meet", "am meeting", "am going to meet", "meet"),
                "questionText" to "I ___ my friend at the coffee shop tomorrow."
            ),
            mapOf(
                "correctAnswer" to "will help",
                "level" to 7,
                "options" to listOf("will help", "am helping", "am going to help", "help"),
                "questionText" to "I ___ you with your homework later."
            ),
            mapOf(
                "correctAnswer" to "am going to buy",
                "level" to 7,
                "options" to listOf("will buy", "am buying", "am going to buy", "buy"),
                "questionText" to "I ___ a new car next month."
            ),
            mapOf(
                "correctAnswer" to "am visiting",
                "level" to 7,
                "options" to listOf("will visit", "am visiting", "am going to visit", "visit"),
                "questionText" to "I ___ my grandparents next weekend."
            ),
            mapOf(
                "correctAnswer" to "will call",
                "level" to 7,
                "options" to listOf("will call", "am calling", "am going to call", "call"),
                "questionText" to "I ___ you when I get home."
            ),
            mapOf(
                "correctAnswer" to "am going to move",
                "level" to 7,
                "options" to listOf("will move", "am moving", "am going to move", "move"),
                "questionText" to "I ___ to a new house soon."
            ),
            mapOf(
                "correctAnswer" to "will cook",
                "level" to 7,
                "options" to listOf("will cook", "am cooking", "am going to cook", "cook"),
                "questionText" to "I ___ dinner for everyone tonight."
            ),
            mapOf(
                "correctAnswer" to "am starting",
                "level" to 7,
                "options" to listOf("will start", "am starting", "am going to start", "start"),
                "questionText" to "I ___ a new job next Monday."
            ),
            mapOf(
                "correctAnswer" to "will rain",
                "level" to 7,
                "options" to listOf("will rain", "is raining", "is going to rain", "rains"),
                "questionText" to "I think it ___ tomorrow."
            ),
            mapOf(
                "correctAnswer" to "is going to snow",
                "level" to 7,
                "options" to listOf("will snow", "is snowing", "is going to snow", "snows"),
                "questionText" to "Look at the clouds! It ___ soon."
            ),
            mapOf(
                "correctAnswer" to "will decide",
                "level" to 7,
                "options" to listOf("will decide", "am deciding", "am going to decide", "decide"),
                "questionText" to "I ___ what to do after I hear your opinion."
            ),
            mapOf(
                "correctAnswer" to "is going to be",
                "level" to 7,
                "options" to listOf("will be", "is being", "is going to be", "is"),
                "questionText" to "It ___ a sunny day tomorrow."
            ),
            mapOf(
                "correctAnswer" to "is arriving",
                "level" to 7,
                "options" to listOf("will arrive", "is arriving", "is going to arrive", "arrives"),
                "questionText" to "The train ___ at 8 PM tonight."
            ),
            mapOf(
                "correctAnswer" to "will open",
                "level" to 7,
                "options" to listOf("will open", "is opening", "is going to open", "opens"),
                "questionText" to "The new store ___ next month."
            ),
            mapOf(
                "correctAnswer" to "is going to break",
                "level" to 7,
                "options" to listOf("will break", "is breaking", "is going to break", "breaks"),
                "questionText" to "Be careful! The glass ___ if you drop it."
            ),
            mapOf(
                "correctAnswer" to "am meeting",
                "level" to 7,
                "options" to listOf("will meet", "am meeting", "am going to meet", "meet"),
                "questionText" to "I ___ my team for a project discussion at 10 AM."
            ),
            mapOf(
                "correctAnswer" to "will pass",
                "level" to 7,
                "options" to listOf("will pass", "am passing", "am going to pass", "pass"),
                "questionText" to "Don't worry, you ___ the exam if you study hard."
            ),
            mapOf(
                "correctAnswer" to "is going to explode",
                "level" to 7,
                "options" to listOf("will explode", "is exploding", "is going to explode", "explodes"),
                "questionText" to "Look at the fire! The car ___ any moment now!"
            ),
            mapOf(
                "correctAnswer" to "will help",
                "level" to 7,
                "options" to listOf("will help", "am helping", "am going to help", "help"),
                "questionText" to "If you need me, I ___ you with your project."
            ),
            mapOf(
                "correctAnswer" to "is taking off",
                "level" to 7,
                "options" to listOf("will take off", "is taking off", "is going to take off", "takes off"),
                "questionText" to "The plane ___ at 3 PM tomorrow."
            ),
            mapOf(
                "correctAnswer" to "will visit",
                "level" to 7,
                "options" to listOf("will visit", "am visiting", "am going to visit", "visit"),
                "questionText" to "I ___ my cousin next weekend."
            ),
            mapOf(
                "correctAnswer" to "am going to start",
                "level" to 7,
                "options" to listOf("will start", "am starting", "am going to start", "start"),
                "questionText" to "I ___ a new project next week."
            ),
            mapOf(
                "correctAnswer" to "will become",
                "level" to 7,
                "options" to listOf("will become", "am becoming", "am going to become", "become"),
                "questionText" to "In the future, I ___ a famous artist."
            ),
            mapOf(
                "correctAnswer" to "is going to change",
                "level" to 7,
                "options" to listOf("will change", "is changing", "is going to change", "changes"),
                "questionText" to "The weather forecast says it ___ soon."
            ),
            mapOf(
                "correctAnswer" to "am going to relax",
                "level" to 7,
                "options" to listOf("will relax", "am relaxing", "am going to relax", "relax"),
                "questionText" to "After this meeting, I ___ for the rest of the day."
            ),
            mapOf(
                "correctAnswer" to "will finish",
                "level" to 7,
                "options" to listOf("will finish", "am finishing", "am going to finish", "finish"),
                "questionText" to "I ___ my homework before dinner."
            ),
            mapOf(
                "correctAnswer" to "is going to meet",
                "level" to 7,
                "options" to listOf("will meet", "is meeting", "is going to meet", "meet"),
                "questionText" to "She ___ her friend at 5 PM today."
            ),
            mapOf(
                "correctAnswer" to "am going to call",
                "level" to 7,
                "options" to listOf("will call", "am calling", "am going to call", "call"),
                "questionText" to "I ___ you when I arrive at the airport."
            ),
            mapOf(
                "correctAnswer" to "will take",
                "level" to 7,
                "options" to listOf("will take", "am taking", "am going to take", "take"),
                "questionText" to "The train ___ about an hour to reach the city."
            ),
            mapOf(
                "correctAnswer" to "is going to perform",
                "level" to 7,
                "options" to listOf("will perform", "is performing", "is going to perform", "performs"),
                "questionText" to "The band ___ a concert tomorrow night."
            ),
            mapOf(
                "correctAnswer" to "will have",
                "level" to 7,
                "options" to listOf("will have", "am having", "am going to have", "have"),
                "questionText" to "We ___ a meeting to discuss the new project next week."
            ),
            mapOf(
                "correctAnswer" to "is going to fix",
                "level" to 7,
                "options" to listOf("will fix", "is fixing", "is going to fix", "fixes"),
                "questionText" to "My mechanic ___ my car tomorrow."
            ),
            mapOf(
                "correctAnswer" to "can",
                "level" to 8,
                "options" to listOf("can", "must", "should", "might"),
                "questionText" to "I ___ swim very well."
            ),
            mapOf(
                "correctAnswer" to "must",
                "level" to 8,
                "options" to listOf("can", "must", "should", "might"),
                "questionText" to "You ___ wear a helmet when riding a bike."
            ),
            mapOf(
                "correctAnswer" to "should",
                "level" to 8,
                "options" to listOf("can", "must", "should", "might"),
                "questionText" to "You ___ eat more vegetables."
            ),
            mapOf(
                "correctAnswer" to "might",
                "level" to 8,
                "options" to listOf("can", "must", "should", "might"),
                "questionText" to "I ___ go to the cinema tonight, but I'm not sure."
            ),
            mapOf(
                "correctAnswer" to "could",
                "level" to 8,
                "options" to listOf("can", "could", "may", "must"),
                "questionText" to "When I was younger, I ___ run faster."
            ),
            mapOf(
                "correctAnswer" to "may",
                "level" to 8,
                "options" to listOf("can", "could", "may", "must"),
                "questionText" to "You ___ leave once the meeting is over."
            ),
            mapOf(
                "correctAnswer" to "have to",
                "level" to 8,
                "options" to listOf("must", "have to", "should", "can"),
                "questionText" to "I ___ finish this project by tomorrow."
            ),
            mapOf(
                "correctAnswer" to "can't",
                "level" to 8,
                "options" to listOf("can't", "shouldn't", "mustn't", "might not"),
                "questionText" to "You ___ park here, it's a no-parking zone."
            ),
            mapOf(
                "correctAnswer" to "would",
                "level" to 8,
                "options" to listOf("would", "could", "might", "should"),
                "questionText" to "If I had time, I ___ visit you more often."
            ),
            mapOf(
                "correctAnswer" to "shouldn't",
                "level" to 8,
                "options" to listOf("can't", "shouldn't", "mustn't", "might not"),
                "questionText" to "You ___ skip breakfast, it's important for your health."
            ),
            mapOf(
                "correctAnswer" to "mustn't",
                "level" to 8,
                "options" to listOf("mustn't", "shouldn't", "can't", "couldn't"),
                "questionText" to "You ___ touch the exhibit in the museum."
            ),
            mapOf(
                "correctAnswer" to "could",
                "level" to 8,
                "options" to listOf("can", "could", "may", "should"),
                "questionText" to "She ___ speak three languages when she was young."
            ),
            mapOf(
                "correctAnswer" to "can",
                "level" to 8,
                "options" to listOf("can", "must", "should", "may"),
                "questionText" to "I ___ help you with your homework if you need it."
            ),
            mapOf(
                "correctAnswer" to "must",
                "level" to 8,
                "options" to listOf("can", "must", "should", "might"),
                "questionText" to "You ___ wear a seatbelt when driving."
            ),
            mapOf(
                "correctAnswer" to "should",
                "level" to 8,
                "options" to listOf("can", "must", "should", "might"),
                "questionText" to "You ___ drink more water every day."
            ),
            mapOf(
                "correctAnswer" to "might",
                "level" to 8,
                "options" to listOf("can", "must", "should", "might"),
                "questionText" to "We ___ go to the beach this weekend if it doesn't rain."
            ),
            mapOf(
                "correctAnswer" to "could",
                "level" to 8,
                "options" to listOf("can", "could", "may", "might"),
                "questionText" to "She ___ solve the problem by herself."
            ),
            mapOf(
                "correctAnswer" to "may",
                "level" to 8,
                "options" to listOf("can", "may", "might", "should"),
                "questionText" to "You ___ use my laptop for the presentation."
            ),
            mapOf(
                "correctAnswer" to "have to",
                "level" to 8,
                "options" to listOf("must", "have to", "can", "should"),
                "questionText" to "I ___ leave early to catch my train."
            ),
            mapOf(
                "correctAnswer" to "mustn't",
                "level" to 8,
                "options" to listOf("mustn't", "can't", "shouldn't", "may not"),
                "questionText" to "You ___ forget to lock the door when you leave."
            ),
            mapOf(
                "correctAnswer" to "would",
                "level" to 8,
                "options" to listOf("would", "might", "could", "can"),
                "questionText" to "I ___ like to go to the concert next Friday."
            ),
            mapOf(
                "correctAnswer" to "can't",
                "level" to 8,
                "options" to listOf("can", "can't", "mustn't", "shouldn't"),
                "questionText" to "You ___ drive without a license."
            ),
            mapOf(
                "correctAnswer" to "could",
                "level" to 8,
                "options" to listOf("can", "could", "will", "might"),
                "questionText" to "When I was younger, I ___ run 5 kilometers easily."
            ),
            mapOf(
                "correctAnswer" to "might",
                "level" to 8,
                "options" to listOf("can", "must", "might", "should"),
                "questionText" to "I ___ be able to help you later, but I can't promise."
            ),
            mapOf(
                "correctAnswer" to "must",
                "level" to 8,
                "options" to listOf("can", "must", "should", "might"),
                "questionText" to "You ___ turn off your phone before the meeting starts."
            ),
            mapOf(
                "correctAnswer" to "shouldn't",
                "level" to 8,
                "options" to listOf("shouldn't", "can't", "mustn't", "might not"),
                "questionText" to "You ___ eat so much sugar, it's bad for your health."
            ),
            mapOf(
                "correctAnswer" to "could",
                "level" to 8,
                "options" to listOf("could", "may", "can", "must"),
                "questionText" to "You ___ try calling again later, the line might be busy."
            ),
            mapOf(
                "correctAnswer" to "mustn't",
                "level" to 8,
                "options" to listOf("mustn't", "can't", "shouldn't", "might not"),
                "questionText" to "You ___ park in front of the fire hydrant."
            ),
            mapOf(
                "correctAnswer" to "have to",
                "level" to 8,
                "options" to listOf("have to", "must", "should", "can"),
                "questionText" to "I ___ go to the doctor's appointment tomorrow."
            ),
            mapOf(
                "correctAnswer" to "can",
                "level" to 8,
                "options" to listOf("can", "might", "must", "should"),
                "questionText" to "I ___ help you with the project if you want."
            ),
            mapOf(
                "correctAnswer" to "may",
                "level" to 8,
                "options" to listOf("can", "may", "should", "could"),
                "questionText" to "You ___ leave the office after 6 PM."
            ),
            mapOf(
                "correctAnswer" to "must",
                "level" to 8,
                "options" to listOf("must", "should", "have to", "can"),
                "questionText" to "Students ___ wear uniforms at this school."
            ),
            mapOf(
                "correctAnswer" to "would",
                "level" to 8,
                "options" to listOf("would", "might", "can", "could"),
                "questionText" to "If I had more time, I ___ help you with the task."
            ),
            mapOf(
                "correctAnswer" to "can't",
                "level" to 8,
                "options" to listOf("can't", "mustn't", "shouldn't", "might not"),
                "questionText" to "You ___ enter the building without an ID."
            ),
            mapOf(
                "correctAnswer" to "might",
                "level" to 8,
                "options" to listOf("can", "must", "might", "could"),
                "questionText" to "They ___ cancel the event because of the weather."
            ),
            mapOf(
                "correctAnswer" to "could",
                "level" to 8,
                "options" to listOf("can", "might", "could", "would"),
                "questionText" to "She ___ speak three languages when she was young."
            ),
            mapOf(
                "correctAnswer" to "should",
                "level" to 8,
                "options" to listOf("should", "must", "can", "might"),
                "questionText" to "You ___ read this book, it's really interesting."
            ),
            mapOf(
                "correctAnswer" to "might",
                "level" to 8,
                "options" to listOf("can", "might", "should", "could"),
                "questionText" to "It ___ rain tomorrow, so take an umbrella just in case."
            ),
            mapOf(
                "correctAnswer" to "must",
                "level" to 8,
                "options" to listOf("must", "can", "should", "might"),
                "questionText" to "You ___ leave the office now."
            ),
            mapOf(
                "correctAnswer" to "could",
                "level" to 8,
                "options" to listOf("could", "must", "may", "can"),
                "questionText" to "If you needed help, you ___ call me anytime."
            ),
            mapOf(
                "correctAnswer" to "mustn't",
                "level" to 8,
                "options" to listOf("mustn't", "shouldn't", "can't", "may not"),
                "questionText" to "You ___ bring food into the library."
            ),
            mapOf(
                "correctAnswer" to "will go",
                "level" to 9,
                "options" to listOf("will go", "go", "went", "going"),
                "questionText" to "If it rains tomorrow, I ___ to the park."
            ),
            mapOf(
                "correctAnswer" to "would buy",
                "level" to 9,
                "options" to listOf("would buy", "will buy", "buys", "buy"),
                "questionText" to "If I had a lot of money, I ___ a new car."
            ),
            mapOf(
                "correctAnswer" to "would have gone",
                "level" to 9,
                "options" to listOf("would have gone", "will go", "went", "go"),
                "questionText" to "If I had known about the party, I ___."
            ),
            mapOf(
                "correctAnswer" to "are going",
                "level" to 9,
                "options" to listOf("are going", "will go", "go", "going"),
                "questionText" to "If you feel better tomorrow, we ___ to the beach."
            ),
            mapOf(
                "correctAnswer" to "would have helped",
                "level" to 9,
                "options" to listOf("would have helped", "help", "will help", "would help"),
                "questionText" to "If I had known you were in trouble, I ___ you."
            ),
            mapOf(
                "correctAnswer" to "would leave",
                "level" to 9,
                "options" to listOf("would leave", "leave", "will leave", "leaves"),
                "questionText" to "If she was tired, she ___ early."
            ),
            mapOf(
                "correctAnswer" to "would study",
                "level" to 9,
                "options" to listOf("would study", "study", "will study", "studies"),
                "questionText" to "If I had more time, I ___ harder."
            ),
            mapOf(
                "correctAnswer" to "would be",
                "level" to 9,
                "options" to listOf("would be", "am", "is", "will be"),
                "questionText" to "If I were you, I ___ more careful."
            ),
            mapOf(
                "correctAnswer" to "wouldn't have forgotten",
                "level" to 9,
                "options" to listOf("wouldn't have forgotten", "won't forget", "didn't forget", "don't forget"),
                "questionText" to "If I had remembered to bring the tickets, I ___ them."
            ),
            mapOf(
                "correctAnswer" to "will call",
                "level" to 9,
                "options" to listOf("will call", "calls", "called", "calling"),
                "questionText" to "If you need me, I ___ you."
            ),
            mapOf(
                "correctAnswer" to "would travel",
                "level" to 9,
                "options" to listOf("would travel", "travel", "will travel", "travels"),
                "questionText" to "If I had the chance, I ___ around the world."
            ),
            mapOf(
                "correctAnswer" to "wouldn't go",
                "level" to 9,
                "options" to listOf("wouldn't go", "won't go", "didn't go", "don't go"),
                "questionText" to "If I were you, I ___ to that party."
            ),
            mapOf(
                "correctAnswer" to "had gone",
                "level" to 9,
                "options" to listOf("had gone", "went", "will go", "go"),
                "questionText" to "If I ___ to bed earlier, I wouldn't be so tired now."
            ),
            mapOf(
                "correctAnswer" to "will be",
                "level" to 9,
                "options" to listOf("will be", "am", "were", "are"),
                "questionText" to "If you help me, I ___ very grateful."
            ),
            mapOf(
                "correctAnswer" to "had studied",
                "level" to 9,
                "options" to listOf("had studied", "studied", "have studied", "study"),
                "questionText" to "If I ___ harder, I would have passed the exam."
            ),
            mapOf(
                "correctAnswer" to "were",
                "level" to 9,
                "options" to listOf("was", "were", "am", "will be"),
                "questionText" to "If I ___ a bird, I would fly across the world."
            ),
            mapOf(
                "correctAnswer" to "will help",
                "level" to 9,
                "options" to listOf("will help", "help", "would help", "helped"),
                "questionText" to "If you ask me, I ___ you with the project."
            ),
            mapOf(
                "correctAnswer" to "wouldn't have gone",
                "level" to 9,
                "options" to listOf("wouldn't have gone", "wouldn't go", "won't go", "don't go"),
                "questionText" to "If I had known it was so far, I ___."
            ),
            mapOf(
                "correctAnswer" to "will finish",
                "level" to 9,
                "options" to listOf("will finish", "finish", "would finish", "finished"),
                "questionText" to "If I work hard, I ___ the task by tomorrow."
            ),
            mapOf(
                "correctAnswer" to "would have taken",
                "level" to 9,
                "options" to listOf("would have taken", "took", "will take", "take"),
                "questionText" to "If I had known about the meeting, I ___ the bus earlier."
            ),
            mapOf(
                "correctAnswer" to "will stay",
                "level" to 9,
                "options" to listOf("will stay", "stays", "stayed", "stay"),
                "questionText" to "If it's not too late, we ___ for another hour."
            ),
            mapOf(
                "correctAnswer" to "will call",
                "level" to 9,
                "options" to listOf("will call", "called", "calling", "call"),
                "questionText" to "If she doesn't answer, I ___ her again later."
            ),
            mapOf(
                "correctAnswer" to "would have been",
                "level" to 9,
                "options" to listOf("would have been", "were", "had been", "will be"),
                "questionText" to "If I had known it was your birthday, I ___ there."
            ),
            mapOf(
                "correctAnswer" to "will go",
                "level" to 9,
                "options" to listOf("will go", "goes", "went", "going"),
                "questionText" to "If I finish my work early, I ___ to the gym."
            ),
            mapOf(
                "correctAnswer" to "would have bought",
                "level" to 9,
                "options" to listOf("would have bought", "bought", "will buy", "buy"),
                "questionText" to "If I had known it was on sale, I ___ it."
            ),
            mapOf(
                "correctAnswer" to "will be",
                "level" to 9,
                "options" to listOf("will be", "is", "am", "was"),
                "questionText" to "If you take the job, you ___ very happy."
            ),
            mapOf(
                "correctAnswer" to "would have traveled",
                "level" to 9,
                "options" to listOf("would have traveled", "traveled", "travel", "would travel"),
                "questionText" to "If they had had enough money, they ___ more."
            ),
            mapOf(
                "correctAnswer" to "had known",
                "level" to 9,
                "options" to listOf("had known", "know", "knew", "knowing"),
                "questionText" to "If I ___ about the traffic, I would have left earlier."
            ),
            mapOf(
                "correctAnswer" to "would not have said",
                "level" to 9,
                "options" to listOf("would not have said", "won't say", "didn't say", "wouldn't say"),
                "questionText" to "If I had known it was a secret, I ___ anything."
            ),
            mapOf(
                "correctAnswer" to "will do",
                "level" to 9,
                "options" to listOf("will do", "do", "did", "doing"),
                "questionText" to "If you help me, I ___ the rest of the work."
            ),
            mapOf(
                "correctAnswer" to "would be",
                "level" to 9,
                "options" to listOf("would be", "am", "will be", "were"),
                "questionText" to "If she were here, she ___ really happy."
            ),
            mapOf(
                "correctAnswer" to "will take",
                "level" to 9,
                "options" to listOf("will take", "takes", "took", "taking"),
                "questionText" to "If I hurry, I ___ the bus."
            ),
            mapOf(
                "correctAnswer" to "had studied",
                "level" to 9,
                "options" to listOf("had studied", "studied", "study", "studies"),
                "questionText" to "If I ___ harder, I would have passed the exam."
            ),
            mapOf(
                "correctAnswer" to "will be",
                "level" to 9,
                "options" to listOf("will be", "will have been", "is", "are"),
                "questionText" to "If they arrive early, we ___ waiting for them."
            ),
            mapOf(
                "correctAnswer" to "will help",
                "level" to 9,
                "options" to listOf("will help", "help", "would help", "helped"),
                "questionText" to "If you need advice, I ___ you."
            ),
            mapOf(
                "correctAnswer" to "would have gone",
                "level" to 9,
                "options" to listOf("would have gone", "went", "will go", "going"),
                "questionText" to "If I had known about the event, I ___ there."
            ),
            mapOf(
                "correctAnswer" to "would have invited",
                "level" to 9,
                "options" to listOf("would have invited", "invited", "will invite", "invite"),
                "questionText" to "If I had known you were in town, I ___ you to the party."
            ),
            mapOf(
                "correctAnswer" to "would go",
                "level" to 9,
                "options" to listOf("would go", "go", "will go", "went"),
                "questionText" to "If I were free, I ___ to the concert."
            ),
            mapOf(
                "correctAnswer" to "will be",
                "level" to 9,
                "options" to listOf("will be", "was", "am", "are"),
                "questionText" to "If the weather is nice, we ___ having a barbecue."
            ),
            mapOf(
                "correctAnswer" to "would have worked",
                "level" to 9,
                "options" to listOf("would have worked", "worked", "will work", "works"),
                "questionText" to "If I had known how to solve the issue, I ___ harder."
            ),
            mapOf(
                "correctAnswer" to "would have been",
                "level" to 9,
                "options" to listOf("would have been", "was", "is", "are"),
                "questionText" to "If I had known about the concert, I ___ there."
            ),
            mapOf(
                "correctAnswer" to "will finish",
                "level" to 9,
                "options" to listOf("will finish", "finish", "would finish", "finishes"),
                "questionText" to "If I get up early, I ___ the project by noon."
            ),
            mapOf(
                "correctAnswer" to "will visit",
                "level" to 9,
                "options" to listOf("will visit", "visit", "visited", "visiting"),
                "questionText" to "If I go to New York next week, I ___ my friend."
            ),
            mapOf(
                "correctAnswer" to "would have helped",
                "level" to 9,
                "options" to listOf("would have helped", "helped", "will help", "help"),
                "questionText" to "If I had seen your message earlier, I ___ you."
            ),
            mapOf(
                "correctAnswer" to "had known",
                "level" to 9,
                "options" to listOf("had known", "know", "knew", "knowing"),
                "questionText" to "If I ___ about the meeting, I would have attended."
            ),
            mapOf(
                "correctAnswer" to "would leave",
                "level" to 9,
                "options" to listOf("would leave", "left", "leave", "leaves"),
                "questionText" to "If she wasn't feeling well, she ___ the office early."
            ),
            mapOf(
                "correctAnswer" to "will come",
                "level" to 9,
                "options" to listOf("will come", "comes", "came", "coming"),
                "questionText" to "If she can, she ___ to the meeting tomorrow."
            ),
            mapOf(
                "correctAnswer" to "wouldn't have said",
                "level" to 9,
                "options" to listOf("wouldn't have said", "didn't say", "won't say", "wouldn't say"),
                "questionText" to "If I had known how hurtful my words were, I ___ them."
            ),
            mapOf(
                "correctAnswer" to "would be",
                "level" to 9,
                "options" to listOf("would be", "will be", "is", "are"),
                "questionText" to "If you were to work harder, your results ___ better."
            ),
            mapOf(
                "correctAnswer" to "would have eaten",
                "level" to 9,
                "options" to listOf("would have eaten", "eat", "ate", "eats"),
                "questionText" to "If I had known there was food at the event, I ___."
            ),
            mapOf(
                "correctAnswer" to "will attend",
                "level" to 9,
                "options" to listOf("will attend", "attend", "attended", "attending"),
                "questionText" to "If I get an invitation, I ___ the wedding."
            ),
            mapOf(
                "correctAnswer" to "would work",
                "level" to 9,
                "options" to listOf("would work", "works", "worked", "work"),
                "questionText" to "If I were in your shoes, I ___ harder to meet the deadline."
            ),
            mapOf(
                "correctAnswer" to "had known",
                "level" to 9,
                "options" to listOf("had known", "knew", "knowing", "know"),
                "questionText" to "If I ___ how important the task was, I would have worked harder."
            ),
            mapOf(
                "correctAnswer" to "will call",
                "level" to 9,
                "options" to listOf("will call", "call", "called", "calling"),
                "questionText" to "If I find my keys, I ___ you."
            ),
            mapOf(
                "correctAnswer" to "break down",
                "level" to 10,
                "options" to listOf("break down", "break up", "break out", "break in"),
                "questionText" to "My car suddenly ___ on the way to work."
            ),
            mapOf(
                "correctAnswer" to "give up",
                "level" to 10,
                "options" to listOf("give up", "give in", "give out", "give away"),
                "questionText" to "I won't ___ on my dreams no matter what."
            ),
            mapOf(
                "correctAnswer" to "look forward to",
                "level" to 10,
                "options" to listOf("look forward to", "look after", "look into", "look out for"),
                "questionText" to "I ___ seeing you at the party next weekend."
            ),
            mapOf(
                "correctAnswer" to "call off",
                "level" to 10,
                "options" to listOf("call off", "call out", "call up", "call in"),
                "questionText" to "They had to ___ the meeting because of the snowstorm."
            ),
            mapOf(
                "correctAnswer" to "take after",
                "level" to 10,
                "options" to listOf("take after", "take off", "take in", "take over"),
                "questionText" to "She really ___ her mother in both looks and personality."
            ),
            mapOf(
                "correctAnswer" to "run out of",
                "level" to 10,
                "options" to listOf("run out of", "run into", "run over", "run away"),
                "questionText" to "We need to go to the store because we ___ milk."
            ),
            mapOf(
                "correctAnswer" to "bring up",
                "level" to 10,
                "options" to listOf("bring up", "bring in", "bring down", "bring out"),
                "questionText" to "She always ___ her childhood when we're talking about family."
            ),
            mapOf(
                "correctAnswer" to "get along with",
                "level" to 10,
                "options" to listOf("get along with", "get by", "get over", "get ahead"),
                "questionText" to "I really ___ my new coworkers; they're so friendly."
            ),
            mapOf(
                "correctAnswer" to "turn down",
                "level" to 10,
                "options" to listOf("turn down", "turn up", "turn over", "turn in"),
                "questionText" to "He had to ___ the job offer because the salary was too low."
            ),
            mapOf(
                "correctAnswer" to "come up with",
                "level" to 10,
                "options" to listOf("come up with", "come down with", "come over", "come across"),
                "questionText" to "I need to ___ a new idea for the project."
            ),
            mapOf(
                "correctAnswer" to "pick up",
                "level" to 10,
                "options" to listOf("pick up", "pick out", "pick off", "pick in"),
                "questionText" to "Can you ___ some groceries on your way home?"
            ),
            mapOf(
                "correctAnswer" to "give in",
                "level" to 10,
                "options" to listOf("give in", "give up", "give away", "give out"),
                "questionText" to "After hours of negotiation, they finally ___ to our demands."
            ),
            mapOf(
                "correctAnswer" to "hold on",
                "level" to 10,
                "options" to listOf("hold on", "hold off", "hold up", "hold out"),
                "questionText" to "___ a second! I'll be right with you."
            ),
            mapOf(
                "correctAnswer" to "check out",
                "level" to 10,
                "options" to listOf("check out", "check in", "check up", "check on"),
                "questionText" to "You should really ___ that new movie; it's fantastic."
            ),
            mapOf(
                "correctAnswer" to "run into",
                "level" to 10,
                "options" to listOf("run into", "run over", "run through", "run up"),
                "questionText" to "I ___ my old teacher at the supermarket yesterday."
            ),
            mapOf(
                "correctAnswer" to "get over",
                "level" to 10,
                "options" to listOf("get over", "get by", "get ahead", "get along with"),
                "questionText" to "It took me a long time to ___ the breakup."
            ),
            mapOf(
                "correctAnswer" to "take off",
                "level" to 10,
                "options" to listOf("take off", "take over", "take out", "take up"),
                "questionText" to "The plane will ___ in a few minutes."
            ),
            mapOf(
                "correctAnswer" to "cut down on",
                "level" to 10,
                "options" to listOf("cut down on", "cut off", "cut out", "cut back on"),
                "questionText" to "I'm trying to ___ sugar to improve my health."
            ),
            mapOf(
                "correctAnswer" to "bring about",
                "level" to 10,
                "options" to listOf("bring about", "bring in", "bring out", "bring down"),
                "questionText" to "The new policy will ___ positive changes in the company."
            ),
            mapOf(
                "correctAnswer" to "set up",
                "level" to 10,
                "options" to listOf("set up", "set off", "set out", "set in"),
                "questionText" to "They will ___ a meeting for tomorrow afternoon."
            ),
            mapOf(
                "correctAnswer" to "call up",
                "level" to 10,
                "options" to listOf("call up", "call out", "call in", "call on"),
                "questionText" to "I need to ___ my friend to see if she's coming to the party."
            ),
            mapOf(
                "correctAnswer" to "let down",
                "level" to 10,
                "options" to listOf("let down", "let off", "let in", "let up"),
                "questionText" to "I promised to help her, but I really ___."
            ),
            mapOf(
                "correctAnswer" to "take over",
                "level" to 10,
                "options" to listOf("take over", "take off", "take out", "take in"),
                "questionText" to "The new manager will ___ the project next week."
            ),
            mapOf(
                "correctAnswer" to "hold back",
                "level" to 10,
                "options" to listOf("hold back", "hold on", "hold out", "hold off"),
                "questionText" to "I had to ___ my tears during the emotional speech."
            ),
            mapOf(
                "correctAnswer" to "run across",
                "level" to 10,
                "options" to listOf("run across", "run over", "run into", "run through"),
                "questionText" to "I ___ a really interesting book while cleaning my desk."
            ),
            mapOf(
                "correctAnswer" to "take up",
                "level" to 10,
                "options" to listOf("take up", "take over", "take out", "take in"),
                "questionText" to "She decided to ___ yoga to stay fit."
            ),
            mapOf(
                "correctAnswer" to "get by",
                "level" to 10,
                "options" to listOf("get by", "get along with", "get ahead", "get over"),
                "questionText" to "Even though things are tough, we manage to ___."
            ),
            mapOf(
                "correctAnswer" to "show up",
                "level" to 10,
                "options" to listOf("show up", "show off", "show out", "show in"),
                "questionText" to "He was the only one to ___ on time for the meeting."
            ),
            mapOf(
                "correctAnswer" to "run out of",
                "level" to 10,
                "options" to listOf("run out of", "run away from", "run up to", "run through"),
                "questionText" to "We ___ ideas for the project."
            ),
            mapOf(
                "correctAnswer" to "pick up",
                "level" to 10,
                "options" to listOf("pick up", "pick out", "pick over", "pick in"),
                "questionText" to "I need to ___ some supplies from the store."
            ),
            mapOf(
                "correctAnswer" to "give away",
                "level" to 10,
                "options" to listOf("give away", "give up", "give out", "give in"),
                "questionText" to "She decided to ___ all her old clothes to charity."
            ),
            mapOf(
                "correctAnswer" to "come up with",
                "level" to 10,
                "options" to listOf("come up with", "come over", "come across", "come by"),
                "questionText" to "I can't ___ any ideas for our next project."
            ),
            mapOf(
                "correctAnswer" to "run over",
                "level" to 10,
                "options" to listOf("run over", "run across", "run through", "run away"),
                "questionText" to "I accidentally ___ my foot while backing out of the driveway."
            ),
            mapOf(
                "correctAnswer" to "get ahead",
                "level" to 10,
                "options" to listOf("get ahead", "get by", "get over", "get along with"),
                "questionText" to "In order to ___ in your career, you need to keep learning."
            ),
            mapOf(
                "correctAnswer" to "hold off",
                "level" to 10,
                "options" to listOf("hold off", "hold up", "hold on", "hold out"),
                "questionText" to "Let's ___ making a decision until we have all the facts."
            ),
            mapOf(
                "correctAnswer" to "bring in",
                "level" to 10,
                "options" to listOf("bring in", "bring up", "bring out", "bring down"),
                "questionText" to "They decided to ___ an expert to help with the issue."
            ),
            mapOf(
                "correctAnswer" to "turn up",
                "level" to 10,
                "options" to listOf("turn up", "turn out", "turn over", "turn off"),
                "questionText" to "We waited for an hour, but she didn't ___."
            ),
            mapOf(
                "correctAnswer" to "take over",
                "level" to 10,
                "options" to listOf("take over", "take out", "take up", "take off"),
                "questionText" to "She was excited to ___ as the new team leader."
            ),
            mapOf(
                "correctAnswer" to "get over",
                "level" to 10,
                "options" to listOf("get over", "get along with", "get by", "get ahead"),
                "questionText" to "It took her a long time to ___ the disappointment."
            ),
            mapOf(
                "correctAnswer" to "pick out",
                "level" to 10,
                "options" to listOf("pick out", "pick off", "pick in", "pick up"),
                "questionText" to "Can you ___ a nice gift for my sister?"
            ),
            mapOf(
                "correctAnswer" to "put off",
                "level" to 10,
                "options" to listOf("put off", "put out", "put on", "put up"),
                "questionText" to "We had to ___ the meeting until next week."
            ),
            mapOf(
                "correctAnswer" to "run into",
                "level" to 10,
                "options" to listOf("run into", "run up", "run out of", "run through"),
                "questionText" to "I unexpectedly ___ my old teacher at the store."
            ),
            mapOf(
                "correctAnswer" to "look up to",
                "level" to 10,
                "options" to listOf("look up to", "look out for", "look after", "look into"),
                "questionText" to "He really ___ his older brother and wants to be like him."
            ),
            mapOf(
                "correctAnswer" to "fall through",
                "level" to 10,
                "options" to listOf("fall through", "fall out", "fall in", "fall back"),
                "questionText" to "The deal might ___ if we can't agree on the terms."
            ),
            mapOf(
                "correctAnswer" to "take in",
                "level" to 10,
                "options" to listOf("take in", "take out", "take off", "take over"),
                "questionText" to "It's hard to ___ all this information at once."
            ),
            mapOf(
                "correctAnswer" to "bring down",
                "level" to 10,
                "options" to listOf("bring down", "bring up", "bring out", "bring in"),
                "questionText" to "The new policy might ___ the company's expenses."
            ),
            mapOf(
                "correctAnswer" to "turn out",
                "level" to 10,
                "options" to listOf("turn out", "turn up", "turn in", "turn off"),
                "questionText" to "Everything ___ fine in the end."
            ),
            mapOf(
                "correctAnswer" to "bring up",
                "level" to 10,
                "options" to listOf("bring up", "bring in", "bring out", "bring down"),
                "questionText" to "He always ___ politics during family dinners."
            ),
            mapOf(
                "correctAnswer" to "go over",
                "level" to 10,
                "options" to listOf("go over", "go out", "go by", "go in"),
                "questionText" to "Let's ___ the details of the plan one more time."
            ),
            mapOf(
                "correctAnswer" to "hold up",
                "level" to 10,
                "options" to listOf("hold up", "hold on", "hold out", "hold off"),
                "questionText" to "Sorry I'm late; I was ___ in traffic."
            ),
            mapOf(
                "correctAnswer" to "take after",
                "level" to 10,
                "options" to listOf("take after", "take out", "take off", "take over"),
                "questionText" to "She definitely ___ her father in terms of personality."
            ),
            mapOf(
                "correctAnswer" to "call off",
                "level" to 10,
                "options" to listOf("call off", "call up", "call in", "call on"),
                "questionText" to "We had to ___ the picnic because of the rain."
            ),
            mapOf(
                "correctAnswer" to "run up",
                "level" to 10,
                "options" to listOf("run up", "run out of", "run into", "run through"),
                "questionText" to "They ___ quite a large bill at the restaurant."
            ),
            mapOf(
                "correctAnswer" to "take up",
                "level" to 10,
                "options" to listOf("take up", "take off", "take over", "take out"),
                "questionText" to "She decided to ___ photography as a hobby."
            ),
            mapOf(
                "correctAnswer" to "check in",
                "level" to 10,
                "options" to listOf("check in", "check out", "check up", "check off"),
                "questionText" to "I need to ___ at the airport at least two hours before my flight."
            ),
            mapOf(
                "correctAnswer" to "come across",
                "level" to 10,
                "options" to listOf("come across", "come by", "come up with", "come over"),
                "questionText" to "I ___ a really interesting article yesterday."
            ),
            mapOf(
                "correctAnswer" to "show off",
                "level" to 10,
                "options" to listOf("show off", "show out", "show in", "show up"),
                "questionText" to "He likes to ___ his new car to everyone."
            ),
            mapOf(
                "correctAnswer" to "look out for",
                "level" to 10,
                "options" to listOf("look out for", "look after", "look into", "look up to"),
                "questionText" to "Be careful when crossing the street; always ___ traffic."
            ),
            mapOf(
                "correctAnswer" to "put out",
                "level" to 10,
                "options" to listOf("put out", "put up", "put down", "put on"),
                "questionText" to "They had to ___ the fire quickly to prevent damage."
            ),
            mapOf(
                "correctAnswer" to "hold on",
                "level" to 10,
                "options" to listOf("hold on", "hold off", "hold out", "hold up"),
                "questionText" to "___ a moment; I’ll check the schedule."
            ),
            mapOf(
                "correctAnswer" to "break down",
                "level" to 10,
                "options" to listOf("break down", "break in", "break out", "break up"),
                "questionText" to "Her car ___ right before the important meeting."
            ),
            mapOf(
                "correctAnswer" to "go through",
                "level" to 10,
                "options" to listOf("go through", "go over", "go out", "go in"),
                "questionText" to "We need to ___ the budget for the next quarter."
            ),
            mapOf(
                "correctAnswer" to "take off",
                "level" to 10,
                "options" to listOf("take off", "take over", "take out", "take in"),
                "questionText" to "The airplane is about to ___, so please fasten your seatbelt."
            ),
            mapOf(
                "correctAnswer" to "come over",
                "level" to 10,
                "options" to listOf("come over", "come by", "come up with", "come out"),
                "questionText" to "They’re going to ___ to our place for dinner tomorrow."
            ),
            mapOf(
                "correctAnswer" to "get away with",
                "level" to 10,
                "options" to listOf("get away with", "get ahead", "get along with", "get by"),
                "questionText" to "She always ___ not doing her homework on time."
            ),
            mapOf(
                "correctAnswer" to "bring out",
                "level" to 10,
                "options" to listOf("bring out", "bring in", "bring up", "bring down"),
                "questionText" to "That movie really ___ her acting talent."
            ),
            mapOf(
                "correctAnswer" to "take back",
                "level" to 10,
                "options" to listOf("take back", "take over", "take out", "take off"),
                "questionText" to "I had to ___ my words after realizing I was wrong."
            )
            )


        questions.forEach { question ->
            db.collection("questions")
                .add(question)
                .addOnSuccessListener { documentReference ->
                    Log.d("DatabaseSeeder", "Question added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.e("DatabaseSeeder", "Error adding question", e)
                }
        }
    }
} 