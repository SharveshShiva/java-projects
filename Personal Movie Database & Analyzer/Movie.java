class Movie {
    private String movieName;
    private int releaseYear;
    private String Director;
    private int Duration;
    private double Rating;
    private String[] actorCast;

    // setting and getting variables which is mentioned above.
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setDirector(String Director) {
        this.Director = Director;
    }

    public void setDuration(int Duration) {
        this.Duration = Duration;
    }

    public void setRating(double Rating) {
        this.Rating = Rating;
    }

    public void setActorCast(String[] actorCast) {
        this.actorCast = actorCast;
    }

    public String getMovieName() {
        return movieName;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getDirector() {
        return Director;
    }

    public double getRating() {
        return Rating;
    }

    public int getDuration() {
        return Duration;
    }

    public String[] getActorCast() {
        return actorCast;
    }

    // Adding methods to the class.
    //1
    public void display_free(String movieName, String director, int year) {
        System.out.println("The Movie name is " + movieName + ".");
        System.out.println("Filmed by " + director + " and releases in the year " + year + ".");
    }

    //2
    public String getMovieReportCard(String movieName, String director, int year,
                                     double rating, String[] cast, int duration) {
        StringBuilder report = new StringBuilder();
        report.append("╔══════════════════════════════════════════════════════╗\n");
        report.append("║               MOVIE REPORT CARD 📋                  ║\n");
        report.append("╠══════════════════════════════════════════════════════╣\n\n");

        report.append("🎬 BASIC INFORMATION\n");
        report.append("   ──────────────────────────\n");

        // movie
        if(movieName == null){
            report.append("   • Title:      ").append("N/A").append("\n");
        }
        else{
            report.append("   • Title:      ").append(movieName).append("\n");
        }

        // director
        if(director == null){
            report.append("   • Director:   ").append("N/A").append("\n");
        }
        else{
            report.append("   • Director:   ").append(director).append("\n");
        }

        // Year
        if(year == 0){
            report.append("   • Year:       ").append("N/A").append("\n");
        }
        else{
            report.append("   • Year:       ").append(year).append("\n");
        }

        report.append("⭐ RATING ANALYSIS\n");
        report.append("   ──────────────────────────\n");
        report.append("   • IMDB Score: ").append(rating).append("/10\n");

        int stars = (int) Math.round(rating / 2);
        report.append("   • Star Rating: ");
        for(int i=1; i<=5; i++){
            if(i <= stars)
                report.append("★");
            else {
                report.append("☆");
            }
        }
        report.append(" (").append(stars).append("/5)");
        report.append("\n");

        String ratingCategory;
        if (rating >= 9.0) ratingCategory = "🏆 Masterpiece";
        else if (rating >= 8.0) ratingCategory = "⭐ Excellent";
        else if (rating >= 7.0) ratingCategory = "👍 Good";
        else if (rating >= 6.0) ratingCategory = "➖ Average";
        else ratingCategory = "⚠️ Below Average";
        report.append("   • Category:   ").append(ratingCategory).append("\n\n");

        report.append("⏰ TECHNICAL DETAILS\n");
        report.append("   ──────────────────────────\n");

        int hours = duration / 60;
        int minutes = duration % 60;
        report.append("   • Duration:   ").append(duration).append(" minutes");
        if (hours > 0) {
            report.append(" (").append(hours).append("h ").append(minutes).append("m)");
        }
        report.append("\n");
        if (duration > 180) report.append("   • Note:       Epic length film ⏳\n");
        else if (duration > 150) report.append("   • Note:       Long film 🕰️\n");
        else if (duration < 90) report.append("   • Note:       Short film ⏳\n");
        report.append("\n");

        report.append("🎭 CAST ANALYSIS\n");
        report.append("   ──────────────────────────\n");

        int actorCount = (cast != null) ? cast.length : 0;
        report.append("   • Cast Size:  ").append(actorCount).append(" actors\n");

        if (cast != null && actorCount > 0) {
            report.append("   • Top Billed:\n");
            for (int i = 0; i < Math.min(3, actorCount); i++) {
                String emoji = (i == 0) ? "👑 " : (i == 1) ? "🥈 " : "🥉 ";
                report.append("     ").append(emoji).append(cast[i]).append("\n");
            }
            if (actorCount > 3) {
                report.append("   • Supporting: ").append(actorCount - 3).append(" more actors\n");
            }
        } else {
            report.append("   • Cast:       No cast information\n");
        }
        report.append("\n");

        report.append("📅 ERA CLASSIFICATION\n");
        report.append("   ──────────────────────────\n");

        if (year < 1920) {
            report.append("   • Silent Film Era (Pre-1920)\n");
            report.append("   • 🎞️ Historical Significance: Very High\n");
        } else if (year < 1950) {
            report.append("   • Golden Age of Hollywood\n");
            report.append("   • ⭐ Historical Significance: High\n");
        } else if (year < 1980) {
            report.append("   • Mid-Century Cinema\n");
            report.append("   • 🎬 Historical Significance: Medium\n");
        } else if (year < 2000) {
            report.append("   • Modern Classic Era\n");
            report.append("   • 📽️ Historical Significance: Established\n");
        } else {
            report.append("   • 21st Century Cinema\n");
            report.append("   • 🆕 Historical Significance: Recent\n");
        }
        report.append("\n");

        report.append("\n╠══════════════════════════════════════════════════════╣\n");
        report.append("║           Report Generated: ").append(java.time.LocalDate.now());
        report.append("           ║\n");
        report.append("╚══════════════════════════════════════════════════════╝");

        return report.toString();
    }

    //3
    public void classicChecker(String movieName, int year) {
        if (year >= 2000) {
            System.out.println(movieName + " is a Modern-film!");
        } else if (year < 2000 && year >= 1990) {
            System.out.println(movieName + " is a 90s Classic!");
        } else if (year < 1990 && year >= 1980) {
            System.out.println(movieName + " is a 80s Classic!");
        } else if (year < 1980 && year >= 1970) {
            System.out.println(movieName + " is a 70s Classic!");
        } else {
            System.out.println(movieName + " is a Vintage-Classic!");
        }
    }

    //4
    public void getDurationInHours(String movieName, int duration) {
        int hours = duration / 60;
        int minutes = duration % 60;
        System.out.println("The Movie " + movieName + " is " + hours + " hours and " + minutes + " minutes long.");
    }

    //5
    public String getRatingCategory(String movieName, double rating) {
        if (rating >= 9.0) {
            return "This Movie " + movieName + " is a MasterPiece.";
        } else if (rating >= 8.0) {
            return "This Movie " + movieName + " is Excellent.";
        } else if (rating >= 7.0) {
            return "This Movie " + movieName + " is Good.";
        } else if (rating >= 6.0) {
            return "This Movie " + movieName + " is Average.";
        } else {
            return "This Movie " + movieName + " is Below-Average.";
        }
    }

    //6
    public int countActor(String[] actors) {
        if (actors == null) return 0;
        return actors.length;
    }

    //7  Need movieName parameter
    public String findActor(String actorName, String movieName, String[] actors) {
        if (actors == null) return "No cast information for " + movieName;

        for (String actor : actors) {
            if (actor.equalsIgnoreCase(actorName)) {
                return actor + " exists in the movie " + movieName + ".";
            }
        }
        return actorName + " is not in the movie " + movieName + ".";
    }

    //8
    public String getMovieSummary(String movieName, int year, String director, double rating) {
        return movieName + " (" + year + ") - Directed by " + director + " - Rating: " + rating + "/10";
    }

    //9 Need movieName and actors parameters
    public String findActorRole(String actorName, String movieName, String[] actors) {
        System.out.println("Checking if actor is main or supporting role...");
        if (actors == null) return "No cast information available.";

        for (int i = 0; i < actors.length; i++) {
            if (actors[i].equalsIgnoreCase(actorName)) {
                if (i < 3) {
                    return actorName + " is one of the Main artists in the movie " + movieName + ".";
                } else {
                    return actorName + " is one of the support role artists in the movie " + movieName + ".";
                }
            }
        }
        return actorName + " is not in the movie " + movieName + ".";
    }

    //10 Need movieName and releaseYear parameters
    public String movieAnniversaryCalculator(String movieName, int movieYear, int inputYear) {
        if (inputYear <= 0) {
            return "Invalid year entered! Please enter a positive year.";
        }
        if (movieYear == 0) {
            return "Cannot calculate: Movie release year not set";
        }
        if (inputYear > movieYear) {
            int remain = inputYear - movieYear;
            return "The movie " + movieName + " will be celebrating its " + remain + " years in " + inputYear;
        } else if (inputYear == movieYear) {
            return "That's the same year the movie was released!";
        } else {
            return "The movie is not released yet in the year you have entered.";
        }
    }
}






