public class videointro {
    public static void main(String[] args) {
        try {
            // Error phase
            printWithDelay("FATAL ERROR: Student Intro Failed", 1200);
            printWithDelay("      ", 1400);
            printWithDelay("Error Code: 404-Student-NotFound", 1400);
            printWithDelay("      ", 1400);
            printWithDelay("Attempting Reboot...", 1600);

            System.out.println(); // blank line for spacing

            // Boot-up simulation
            printWithDelay("System.out.println(\"Initializing Student...\");", 1500);
            printWithDelay("      ", 1400);
            printWithDelay("Name = \"[Your Name]\";", 1500);
            printWithDelay("      ", 1400);
            printWithDelay("Status = \"Booting...\";", 1800);

            System.out.println(); // blank line for spacing

            printWithDelay("BOOT SUCCESSFUL", 2000);
            System.out.println();

            // Profile block
            printWithDelay(">>> Initializing Student Profile…", 1500);
            printWithDelay("   Name: [Your Name]", 1200);
            printWithDelay("   Education: Final-Year, [School]", 1200);
            printWithDelay("   Major: Computer Programming & Development", 1200);
            printWithDelay("   Secondary Major: Cloud Management", 1200);
            printWithDelay("   Status: Online", 1500);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Helper method to print line + delay
    public static void printWithDelay(String message, int delayMillis) throws InterruptedException {
        System.out.println(message);
        Thread.sleep(delayMillis);
    }
}
