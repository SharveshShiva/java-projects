import java.util.Scanner;
class MovieDatabase {
    Scanner sc = new Scanner(System.in);

    private Movie[] movies = new Movie[100];
    int count = 0;  // Only ONE count variable

    public void add_movies(int movieNumber){
        for(int i=0; i<movieNumber; i++){
            Movie movie = new Movie();
            movies[count] = movie;
            count++;  // Increment count

            System.out.print("What is the name of the movie: ");
            movie.setMovieName(sc.nextLine());
            System.out.println("\n");

            System.out.print("In which year the movie is released: ");
            movie.setReleaseYear(sc.nextInt());
            sc.nextLine();
            System.out.println("\n");

            System.out.print("What is the name of the movie director: ");
            movie.setDirector(sc.nextLine());
            System.out.println("\n");

            System.out.print("Timing of the movie in mins: ");
            movie.setDuration(sc.nextInt());
            sc.nextLine();
            System.out.println("\n");

            System.out.print("Rating of the movie: ");
            movie.setRating(sc.nextDouble());
            sc.nextLine();
            System.out.println("\n");

            System.out.print("Enter the number of cast in the movie:");
            int castCount = sc.nextInt();
            sc.nextLine();
            String[] actors = new String[castCount];
            for(int j=0;j<actors.length;j++){
                System.out.print("Enter actor " + (j+1) + ": ");
                actors[j] = sc.nextLine();
            }
            movie.setActorCast(actors);
            System.out.println("\n");
        }
        System.out.println("Total movies in database: " + count);
    }

    public void showMovieList(){
        if(count == 0){
            System.out.println("Database is empty!");
            return;
        }

        for(int i=0; i<count; i++){  // Loop only up to count
            System.out.println((i+1) + ". Movie name: " + movies[i].getMovieName());
            System.out.println("Year: " + movies[i].getReleaseYear());
            System.out.println("Director: " + movies[i].getDirector());
            System.out.println("Duration(in mins): " + movies[i].getDuration());
            System.out.println("Rating: " + movies[i].getRating() + "/10");

            String[] actors = movies[i].getActorCast();
            System.out.println("Actors (" + actors.length + "):");
            for (int j = 0; j < actors.length; j++) {
                System.out.println("   " + (j+1) + ". " + actors[j]);
            }
            System.out.println();
        }
        System.out.println("Total: " + count + " movies");
    }

    public Movie movieSelect(String name){
        for(int i=0; i<count; i++){  // Loop only up to count
            if(name.equalsIgnoreCase(movies[i].getMovieName())){
                return movies[i];
            }
        }
        return null;
    }
}
