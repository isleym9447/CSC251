public class videointro {
    public static void main(String[] args) {
        try {
            // Error phase
            typeWriter("FATAL ERROR: Student Intro Failed", 50);
            Thread.sleep(500
            );
            typeWriter("Error Code: 404-Student-NotFound", 50);
            Thread.sleep(1400);
            typeWriter("...", 150);
            typeWriter("ATTEMPTING REBOOT...", 50);
            
            Thread.sleep(1600);

            System.out.println(); // blank line for spacing

            // Boot-up simulation
            typeWriter("CLEARING CASHE...", 40);
            Thread.sleep(1500);
            typeWriter("RE-ESTABLISHING SECURE CONNECTION...", 40);
            Thread.sleep(1500);
            typeWriter("FINALIZING BOOT SEQUENCE...", 40);
            Thread.sleep(1800);
            typeWriter("...", 150);
            typeWriter("...", 150);
            System.out.println(); // blank line for spacing

            typeWriter("BOOT SUCCESSFUL", 60);

            Thread.sleep(2000);
            System.out.println();

            // Profile block
            typeWriter(">>> Initializing Student Profile…", 40);
            Thread.sleep(1000);
            typeWriter("   Name: [MATTEA ISLEY] [9447]", 40);
            Thread.sleep(500
            );
            typeWriter("   Education: Final-Year, [FTCC]", 40);
            Thread.sleep(500
            );
            typeWriter("   Major: Computer Programming & Development", 40);
            Thread.sleep(500
            );
            typeWriter("   Secondary Major: Cloud Management", 40);
            Thread.sleep(500
            );
            typeWriter("   Status: ONLINE", 40);
            Thread.sleep(500
            );
            

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Typewriter effect: prints one character at a time
    public static void typeWriter(String message, int charDelay) throws InterruptedException {
        for (char c : message.toCharArray()) {
            System.out.print(c);
            Thread.sleep(charDelay);
        }
        System.out.println(); // new line after full message
    }
}
