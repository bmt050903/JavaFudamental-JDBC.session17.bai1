package persentation;

import business.MovieManagement;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static MovieManagement movieManagement = new MovieManagement();

    public static void main(String[] args) {

        do {
            System.out.println("****** MOVIE MANAGEMENT ******");
            System.out.println("1. Thêm phim");
            System.out.println("2. Danh sách phim");
            System.out.println("3. Cập nhật phim");
            System.out.println("4. Xóa phim");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addMovie();
                    break;
                case 2:
                    movieManagement.getMovies()
                            .forEach(System.out::println);
                    break;
                case 3:
                    updateMovie();
                    break;
                case 4:
                    deleteMovie();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }

        }while (true);
    }

    //Thêm
    public static void addMovie() {
        System.out.println("Nhập tiêu đề phim: ");
        String title = sc.nextLine();

        System.out.println("Nhập đạo diễn: ");
        String director = sc.nextLine();

        System.out.println("Nhập năm phát hành: ");
        int year = Integer.parseInt(sc.nextLine());

        if (title.isEmpty() || director.isEmpty() || year <= 0) {
            System.out.println("Thông tin không hợp lệ. Vui lòng thử lại.");
            return;
        }
        movieManagement.addMovie(title, director, year);
    }

    //Cập nhật
    public static void updateMovie() {
        System.out.println("Nhập ID phim cần cập nhật: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.println("Nhập tiêu đề phim mới: ");
        String title = sc.nextLine();

        System.out.println("Nhập đạo diễn mới: ");
        String director = sc.nextLine();

        System.out.println("Nhập năm phát hành mới: ");
        int year = Integer.parseInt(sc.nextLine());

        if (title.isEmpty() || director.isEmpty() || year <= 0) {
            System.out.println("Thông tin không hợp lệ. Vui lòng thử lại.");
            return;
        }
        movieManagement.updateMovie(id, title, director, year);
    }

    //Xóa phim
    public static void deleteMovie() {
        System.out.println("Nhập ID phim cần xóa: ");
        int id = Integer.parseInt(sc.nextLine());

        if (id <= 0) {
            System.out.println("ID không hợp lệ. Vui lòng thử lại.");
            return;
        }
        movieManagement.deleteMovie(id);
    }

}
