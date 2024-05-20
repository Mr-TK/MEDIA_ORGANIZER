public class MediaOrganizer {
    public static void main(String[] args) {
        String[] filel = ExtractFileList.fileLocation("E://PHOTOS1");
        String[] imgpath;
        String loc = "";
        String date = "";
        for (int i = 0; i < filel.length; i++) {
            loc = filel[i];
            System.out.println(loc);
            date = ExifToolCreationDateExtractor.main(loc);
            System.out.println(date);
        }
    }
}
