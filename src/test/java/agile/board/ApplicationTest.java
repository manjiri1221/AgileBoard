/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package agile.board;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.agile.board.Application;

class ApplicationTest {
    @Test void healthCheckTest() {
        Application applicationTest = new Application();
        assertTrue("Health Ok".equals(applicationTest.healthCheck()));
        
    }
}
