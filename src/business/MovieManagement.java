package business;

import java.sql.*;

import entity.Movie;
import util.ConnectionDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MovieManagement {
    //Thêm phim
    public void addMovie(String title, String director, int year) {
        try {
            Connection conn = ConnectionDatabase.getConnection();

            //Gọi stored procedure để thêm phim
            CallableStatement call = conn.prepareCall("CALL add_movie(?,?,?)");

            call.setString(1,title);
            call.setString(2,director);
            call.setInt(3,year);

            call.execute();
            System.out.println("Thêm phim thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Hiển thị danh sách
    public List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();

        try {
            Connection conn = ConnectionDatabase.getConnection();

            CallableStatement call = conn.prepareCall("SELECT * FROM list_movies()");

            ResultSet rs = call.executeQuery();

            while (rs.next()) {
                Movie movie = new Movie();

                movie.setId(rs.getInt("id"));
                movie.setTitle(rs.getString("title"));
                movie.setDirector(rs.getString("director"));
                movie.setReleaseYear(rs.getInt("release_year"));

                movies.add(movie);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return movies;
    }

    //Sửa phim
    public void updateMovie(int id, String title, String director, int year) {
        try {
            Connection conn = ConnectionDatabase.getConnection();

            CallableStatement call = conn.prepareCall("CALL update_movie(?,?,?,?)");

            call.setInt(1, id);
            call.setString(2, title);
            call.setString(3, director);
            call.setInt(4, year);

            call.execute();
            System.out.println("Cập nhật phim thành công!");

            call.close();
            ConnectionDatabase.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Xóa phim
    public void deleteMovie(int id) {
        try {
            Connection conn = ConnectionDatabase.getConnection();
            CallableStatement call = conn.prepareCall("CALL delete_movie(?)");

            call.setInt(1, id);
            call.execute();
            System.out.println("Xóa phim thành công!");
            call.close();
            ConnectionDatabase.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
