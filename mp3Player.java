/**
 * Author: Jack Pender
 * Date:   Oct 2024
 * Class:  APCSA
 * Desc:   A program that takes a list of file names as parameters
 *         then parses them based on their title, artist, and release date
 *         and only accepts .mp3 file extensions.
 */

public class mp3Player {

    private static String testStrings[] = {
            "dontStopBelieving-journey-1981.mp3",
            "hello-adele-2015.mp3",
            "hello-adele-2015.mp4",
            "theTwist-chubbyChecker-1960.mp3",
            "sillyLoveSongs-paulMcCartney-1976.mp3",
    };

    public static void main(String[] args) {

        // temporarily replace the user's file names with test file names
        args = testStrings;
        printFileNames("args for testing", args);

        // 1st generate a new array of Strings that ONLY have .mp3 file extensions
        String onlyMP3[] = keepOnlyMP3(args);
        printFileNames("onlyMP3", onlyMP3);

        // 2nd parse the file names into 3 separate categories according to 1. song name,
        // 2. song writer, and 3. year released.
        String[] titles   = parseTitles(onlyMP3);
        String[] artists  = parseArtists(onlyMP3);
        String[] dates    = parseDates(onlyMP3);

        printFileNames("Titles: ", titles);
        printFileNames("Artists: ", artists);
        printFileNames("Dates: ", dates);

        printFileNames("Dates sorted numerically", sortByDate(onlyMP3));
        printFileNames("First names sorted alphabetically", sortByFirstName(onlyMP3));

        noLastNameArtists(onlyMP3);
    }

    /**
     * private method simply prints out a list of file names stored in an array
     * @param prompt : a message (usually the name of the array) to explain purpose
     * @param fn : the array of file names to be printed, one to a line.
     */
    private static void printFileNames(String prompt, String fn[]) {
        System.out.println("File names in the array named: " + prompt);

        for (String n : fn) {
            System.out.println(" " + n);
        }
    }

    /**
     * Checks if the filename extension is .mp3, only returns if
     * the ending is .mp3
     * @param args
     * @return mp3 files
     */
    public static String[] keepOnlyMP3(String[] args) {
        int mP3Counter = 0;
        for (String n : args) {
            if (n.endsWith(".mp3")) mP3Counter++;
        }

        String mp3s[] = new String[mP3Counter];
        int index = 0;

        for (String n : args) {
            if (n.endsWith(".mp3")) {
                mp3s[index++] = n;
            }
        }

        return mp3s;
    }

    /**
     * Parses titles
     * @param mp3s
     * @return titles after they are parsed
     */
    public static String[] parseTitles(String[] mp3s) {
        String[] titles = new String[mp3s.length];
        for (int i = 0; i < mp3s.length; i++) {
            String fileName = mp3s[i];
            int dashIndex = fileName.indexOf('-');
            if (dashIndex != -1) {
                titles[i] = fileName.substring(0, dashIndex);
            }
        }

        return titles;
    }

    /**
     * Parses the artists' names
     * @param mp3s
     * @return artists' names after they've been parsed
     */
    public static String[] parseArtists(String[] mp3s) {
        String[] artists = new String[mp3s.length];
        for (int i = 0; i < mp3s.length; i++) {
            String fileName = mp3s[i];
            int firstDash = fileName.indexOf('-');
            int secondDash = fileName.indexOf('-', firstDash + 1);
            if (firstDash != -1 && secondDash != -1) {
                artists[i] = fileName.substring(firstDash + 1, secondDash);
            }
        }

        return artists;
    }

    /**
     * Parses the release dates of the files
     * @param mp3s
     * @return Parsed dates
     */
    public static String[] parseDates(String[] mp3s) {
        String[] dates = new String[mp3s.length];
        for (int i = 0; i < mp3s.length; i++) {
            String fileName = mp3s[i];
            int lastDash = fileName.lastIndexOf('-');
            if (lastDash != -1) {
                dates[i] = fileName.substring(lastDash + 1, lastDash + 5);
            }
        }

        return dates;
    }

    /**
     * Finds which songs have artists with no last name
     * @param mp3s
     */
    private static void noLastNameArtists(String[] mp3s) {
        System.out.println("Single name artists:");
        for (String file : mp3s) {
            String artistName    = file.substring(file.indexOf('-') + 1, file.lastIndexOf('-'));
            boolean lowerCase    = true;
            for (int i = 0; i < artistName.length(); i++) {
                if (!Character.isLowerCase(artistName.charAt(i))) {
                    lowerCase = false;

                    // breaks out of the if and for loop
                    // stays inside for each loop
                    break;
                }
            }
            if (lowerCase) {
                System.out.println(file);
            }
        }
    }

    /**
     * Sorts the files by their provided date
     * @param mp3s
     * @return The dates of the files in order
     */
    private static String[] sortByDate(String[] mp3s) {
        String[] dates = new String[mp3s.length];
        for (int i = 0; i < mp3s.length; i++) {
            dates[i] = mp3s[i];
        }

        for (int i = 0; i < dates.length - 1; i++) {
            for (int j = 0; j < dates.length - 1; j++) {

                // Integer.parseInt() takes the date from the string and makes it into an integer
                int year  = Integer.parseInt(dates[j].substring(dates[j].lastIndexOf('-') + 1,
                        dates[j].lastIndexOf('-') + 5));
                int year2 = Integer.parseInt(dates[j + 1].substring(dates[j + 1].lastIndexOf('-') + 1,
                        dates[j + 1].lastIndexOf('-') + 5));

                // Swap
                if (year > year2) {
                    String temp      = dates[j];
                    dates[j]     = dates[j + 1];
                    dates[j + 1] = temp;
                }
            }
        }

        return dates;
    }

    /**
     * Sorts the artists by their first name
     * @param mp3s
     * @return
     */
    private static String[] sortByFirstName(String[] mp3s) {
        String[] firstNames = new String[mp3s.length];
        for (int i = 0; i < mp3s.length; i++) {
            firstNames[i] = mp3s[i];
        }

        for (int i = 0; i < firstNames.length - 1; i++) {
            for (int j = 0; j < firstNames.length - 1; j++) {
                String firstName  = firstNames[j].substring(firstNames[j].indexOf('-') + 1,
                        firstNames[j].lastIndexOf('-'));
                String firstName2 = firstNames[j + 1].substring(firstNames[j + 1].indexOf('-') + 1,
                        firstNames[j + 1].lastIndexOf('-'));

                // Swap
                if (firstName.compareTo(firstName2) > 0) {
                    String temp = firstNames[j];
                    firstNames[j]     = firstNames[j + 1];
                    firstNames[j + 1] = temp;
                }
            }
        }

        return firstNames;
    }
}
