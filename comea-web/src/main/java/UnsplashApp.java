import java.util.List;
import java.util.Comparator;
import java.util.Collections;

public class UnsplashApp {
    public static void main(String[] args) {
        List<Photo> photos = getPhotosFromAPI();

        Collections.sort(photos, new Comparator<Photo>() {
            public int compare(Photo photo1, Photo photo2) {
                return photo2.getLikes() - photo1.getLikes();
            }
        });

        for (Photo photo : photos) {
            System.out.println("Autor: " + photo.getAuthor());
            System.out.println("Curtidas: " + photo.getLikes());
            System.out.println("URL da Imagem: " + photo.getImageUrl());
            System.out.println();
        }
    }

    static class Photo {
        private String author;
        private int likes;
        private String imageUrl;

        public Photo(String author, int likes, String imageUrl) {
            this.author = author;
            this.likes = likes;
            this.imageUrl = imageUrl;
        }

        public String getAuthor() {
            return author;
        }

        public int getLikes() {
            return likes;
        }

        public String getImageUrl() {
            return imageUrl;
        }
    }

    static List<Photo> getPhotosFromAPI() {
        return null;
    }
}