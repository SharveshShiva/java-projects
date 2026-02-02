import java.util.Scanner;
public class MovieAdmin {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("You have entered a movie knower/adder where you can: ");

        Movie movie = new Movie();
        MovieDatabase db = new MovieDatabase();
        String movieName = "";
        int releaseYear = 0;
        String director = "";
        double rating = 0.0;
        int duration = 0;
        String[] actors = new String[25];

        boolean is_continue = true;
        while(is_continue) {
            // The options are printed.
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("1. Display the movie list from the database.");
            System.out.println("2. Add new movie and its details to the database.");
            System.out.println("3. Enter the movie name for playing with the methods.");
            System.out.println("4. A short display about the movie.");
            System.out.println("5. Get a detailed report card for the movie you like.");
            System.out.println("6. Check whether the movie is classic or modern (Yearly classic or modern).");
            System.out.println("7. Get to know about the timing of the movie in hours.");
            System.out.println("8. To know whether the movie is good/average/masterpiece.");
            System.out.println("9. Can get to know about the actors count in the movie.");
            System.out.println("10. Find the actor acted in the movie or not.");
            System.out.println("11. Get a movie summary in a line.");
            System.out.println("12. Find the actor whether he is main/supporter.");
            System.out.println("13. You can calculate the year anniversary of the movie by just giving the year.");
            System.out.println("14. Exit the movie knower.");

            System.out.println();
            System.out.println();
            System.out.println("It is mandatory to access the number 2 and 1 options to add the movie data and see if its added.");
            System.out.print("\nEnter choice (1-14): ");
            int options = sc.nextInt();
            sc.nextLine();

            switch (options) {
                case 1:
                    System.out.println("\nMovies in database:");
                    db.showMovieList();
                    break;
                case 2:
                    System.out.print("How many movies to add? ");
                    int movieCount = sc.nextInt();
                    sc.nextLine();
                    db.add_movies(movieCount);
                    break;
                case 3:
                    System.out.print("Enter movie name: ");
                    String name = sc.nextLine();
                    Movie foundMovie = db.movieSelect(name);
                    if(foundMovie != null){
                        movieName = foundMovie.getMovieName();
                        releaseYear = foundMovie.getReleaseYear();
                        director = foundMovie.getDirector();
                        rating = foundMovie.getRating();
                        duration = foundMovie.getDuration();
                        actors = foundMovie.getActorCast();
                        System.out.println("Selected: " + movieName);
                    } else {
                        System.out.println("Movie not found!");
                    }
                    break;
                case 4:
                    if(!movieName.isEmpty()){
                        movie.display_free(movieName, director, releaseYear);
                    } else {
                        System.out.println("No movie selected! Use option 3 first.");
                    }
                    break;
                case 5:
                    if(!movieName.isEmpty()){
                        System.out.println(movie.getMovieReportCard(movieName, director, releaseYear, rating, actors, duration));
                    } else {
                        System.out.println("No movie selected! Use option 3 first.");
                    }
                    break;
                case 6:
                    if(!movieName.isEmpty()){
                        movie.classicChecker(movieName, releaseYear);
                    } else {
                        System.out.println("No movie selected! Use option 3 first.");
                    }
                    break;
                case 7:
                    if(!movieName.isEmpty()){
                        movie.getDurationInHours(movieName, duration);
                    } else {
                        System.out.println("No movie selected! Use option 3 first.");
                    }
                    break;
                case 8:
                    if(!movieName.isEmpty()){
                        System.out.println(movie.getRatingCategory(movieName, rating));
                    } else {
                        System.out.println("No movie selected! Use option 3 first.");
                    }
                    break;
                case 9:
                    if(!movieName.isEmpty()){
                        System.out.println("There are " + movie.countActor(actors) + " actors in " + movieName);
                    } else {
                        System.out.println("No movie selected! Use option 3 first.");
                    }
                    break;
                case 10:
                    if(!movieName.isEmpty()){
                        System.out.print("Enter actor name: ");
                        String actorName = sc.nextLine();
                        System.out.println(movie.findActor(actorName, movieName, actors));
                    } else {
                        System.out.println("No movie selected! Use option 3 first.");
                    }
                    break;
                case 11:
                    if(!movieName.isEmpty()){
                        System.out.println(movie.getMovieSummary(movieName, releaseYear, director, rating));
                    } else {
                        System.out.println("No movie selected! Use option 3 first.");
                    }
                    break;
                case 12:
                    if(!movieName.isEmpty()){
                        System.out.print("Enter actor name: ");
                        String actor = sc.nextLine();
                        System.out.println(movie.findActorRole(actor, movieName, actors));
                    } else {
                        System.out.println("No movie selected! Use option 3 first.");
                    }
                    break;
                case 13:
                    if(!movieName.isEmpty()){
                        System.out.print("Enter year for anniversary: ");
                        int year = sc.nextInt();
                        sc.nextLine();
                        System.out.println(movie.movieAnniversaryCalculator(movieName, releaseYear, year));
                    } else {
                        System.out.println("No movie selected! Use option 3 first.");
                    }
                    break;
                case 14:
                    System.out.println("Thank you for using Movie Database! 😊");
                    is_continue = false;
                    break;
                default:
                    System.out.println("Please enter 1-14");
            }
        }
        sc.close();
    }
}