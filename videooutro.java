public class videooutro {
    public static void main(String[] args) {
        try {
            // Pause before text appears (black screen vibe)
            Thread.sleep(2000);

            typeWriter("...", 150); 
            typeWriter("...", 150);
            Thread.sleep(1000);
            Thread.sleep(1000);
            Thread.sleep(1000);
            Thread.sleep(1000);
            Thread.sleep(1000);
            typeWriter("CONNECTION LOST.", 65);   // 75 ms per letter
            typeWriter("   ", 150);
            Thread.sleep(1000);
            typeWriter("Student [MATTEA ISLEY] has logged off.", 65);
            typeWriter("   ", 150);
            Thread.sleep(1000);
            typeWriter("CONNECTION TERMINATED", 65);
            Thread.sleep(1000);
            typeWriter("...", 150); 
            typeWriter("...", 150);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Prints a message one character at a time
    public static void typeWriter(String message, int delayMillis) throws InterruptedException {
        for (char c : message.toCharArray()) {
            System.out.print(c);
            Thread.sleep(delayMillis);
        }
        System.out.println(); // move to next line after message
    }
}
