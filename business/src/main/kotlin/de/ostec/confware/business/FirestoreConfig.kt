package de.ostec.confware.business

import com.google.cloud.NoCredentials
import com.google.cloud.firestore.Firestore
import com.google.cloud.firestore.FirestoreOptions
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FirestoreConfig {
    @Value("\${test.firestore.emulatorEndpoint:#{null}}")
    var emulatorEndpoint:String? = null

    @Bean
    fun client() : Firestore {
        val firestoreOptionsBuilder = FirestoreOptions.newBuilder()
        emulatorEndpoint?.let {
            firestoreOptionsBuilder.setHost(it)
            firestoreOptionsBuilder.setProjectId("test-project")
            firestoreOptionsBuilder.setCredentials(NoCredentials.getInstance())
        }
        return firestoreOptionsBuilder.build().service
    }
}