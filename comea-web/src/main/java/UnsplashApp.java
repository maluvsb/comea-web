import org.apache.commons.collections4.ComparatorUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UnsplashApp {
    private String accessKey;
    private String apiUrl;

    public UnsplashApp(String accessKey, String apiUrl) {
        this.accessKey = accessKey;
        this.apiUrl = apiUrl;
    }

    // função para ordenar as fotos com base nas curtidas
    private List<Photo> sortPhotosByLikes(List<Photo> photos) {
        Comparator<Photo> likesComparator = ComparatorUtils.chainedComparator(
                Comparator.comparingInt(Photo::getLikes)
        );
        photos.sort(likesComparator);
        return photos;
    }

    // pesquisa de imagem ao receber o valor do input, pega o input e retorna as imagens
    public void searchPhotos(String query) {
        // Simulação da chamada à API e obtenção da lista de fotos
        List<Photo> photos = new ArrayList<>();
        photos.add(new Photo("image1.jpg", 100));
        photos.add(new Photo("image2.jpg", 50));
        photos.add(new Photo("image3.jpg", 200));
        photos.add(new Photo("image4.jpg", 75));

        // Ordena as fotos por quantidade de curtidas
        List<Photo> sortedPhotos = sortPhotosByLikes(photos);

        // Exibe as fotos ordenadas
        for (Photo photo : sortedPhotos) {
            System.out.println(photo);
        }
    }

    public static void main(String[] args) {
        String accessKey = "3BhL2yn5pidgs00JW4hGn---iaS0apdEZBdBdx961M8";
        String apiUrl = "https://api.unsplash.com/search/photos";

        UnsplashApp unsplashApp = new UnsplashApp(accessKey, apiUrl);

        String query = "nature"; // exemplo de pesquisa, substitua pelo valor do input
        unsplashApp.searchPhotos(query);
    }

    static class Photo {
        private String filename;
        private int likes;

        public Photo(String filename, int likes) {
            this.filename = filename;
            this.likes = likes;
        }

        public String getFilename() {
            return filename;
        }

        public int getLikes() {
            return likes;
        }

        @Override
        public String toString() {
            return "Photo{" +
                    "filename='" + filename + '\'' +
                    ", likes=" + likes +
                    '}';
        }
    }
}