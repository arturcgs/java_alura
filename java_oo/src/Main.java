import br.com.alura.screenwatch.models.Movie;
public class Main {
    public static void main(String[] args) {

        Movie matrix = new Movie();

        matrix.setName("The Matrix");
        matrix.setDurationInMinutes(112);
        matrix.setYearLaunch(1998);
        matrix.setIncludedInPlan(true);

        matrix.showsInformation();
        matrix.avaluate(8);
        matrix.avaluate(9);
        matrix.avaluate(10);

        System.out.println("Number of avaluations: " + matrix.getNumberOfAvaluations());
        System.out.println("Avaluations mean: " + matrix.getMean());





    }
}
