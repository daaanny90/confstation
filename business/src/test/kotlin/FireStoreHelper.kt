
import com.google.cloud.NoCredentials
import com.google.cloud.firestore.Firestore
import com.google.cloud.firestore.FirestoreOptions
import org.springframework.test.context.DynamicPropertyRegistry
import org.testcontainers.containers.FirestoreEmulatorContainer
import org.testcontainers.junit.jupiter.Testcontainers
import org.testcontainers.utility.DockerImageName
import org.testcontainers.utility.MountableFile

@Testcontainers
class FireStoreHelper(val emulator:FirestoreEmulatorContainer) {

    companion object {
        private var container: FirestoreEmulatorContainer? = null

        fun getEmulatorContainer(): FirestoreEmulatorContainer {
            if (container === null) {
                container = FirestoreEmulatorContainer(
                    DockerImageName.parse("gcr.io/google.com/cloudsdktool/cloud-sdk:367.0.0-emulators")
                )
            }
            return container!!
        }

        fun setProperties(registry: DynamicPropertyRegistry) {
            registry.add("test.firestore.emulatorEndpoint") { container!!.emulatorEndpoint }
        }

        fun client(): Firestore {
            val options = FirestoreOptions.getDefaultInstance().toBuilder()
                .setHost(container!!.emulatorEndpoint)
                .setCredentials(NoCredentials.getInstance())
                .setProjectId("test-project")
                .build()
            return options.service;
        }
    }
}