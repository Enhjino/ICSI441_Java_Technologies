import java.util.*;
import java.util.stream.Collectors;

class Applicant {
    String program;
    String location;

    public Applicant(String program, String location) {
        this.program = program;
        this.location = location;
    }

    public String getProgram() {
        return program;
    }
    public String getLocation() {
        return program;
    }
}

public class ApplicantAnalysis {
    public static void main(String[] args) {
        int N = 100;
        List<Applicant> applicants = generateRandomApplicants(N);

        Map<String, Long> programCount = applicants.stream()
                .collect(Collectors.groupingBy(Applicant::getProgram, Collectors.counting()));

        System.out.println("Number of students for each program:");
        programCount.forEach((program, count) -> System.out.println(program + ": " + count));

        Map<String, Map<String, Long>> programLocationCount = applicants.stream()
                .collect(Collectors.groupingBy(Applicant::getProgram,
                        Collectors.groupingBy(Applicant::getLocation, Collectors.counting())));

        System.out.println("\nNumber of students for each program from each location:");
        programLocationCount.forEach((program, locationCount) -> {
            System.out.println(program + ":");
            locationCount.forEach((location, count) -> System.out.println("  " + location + ": " + count));
        });

        String mostApplicantsProgram = programCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No program found");

        System.out.println("\nProgram with the most applicants: " + mostApplicantsProgram);
    }

    private static List<Applicant> generateRandomApplicants(int N) {
        List<Applicant> applicants = new ArrayList<>();
        Random random = new Random();

        List<String> programs = Arrays.asList("Computer Science", "Software Engineer", "Information Technology", "Information System");
        List<String> locations = Arrays.asList("Ulaanbaatar","Arkhangai", "Bayan-Ölgii", "Bayankhongor", "Bulgan", "Darkhan-Uul",
                "Dornod", "Dornogovi", "Dundgovi", "Govi-Altai", "Govisümber", "Khentii",
                "Khovd", "Khövsgöl", "Ömnögovi", "Orkhon", "Övörkhangai", "Selenge",
                "Sükhbaatar", "Töv", "Uvs", "Zavkhan");


        for (int i = 0; i < N; i++) {
            String randomProgram = programs.get(random.nextInt(programs.size()));
            String randomLocation = locations.get(random.nextInt(locations.size()));
            applicants.add(new Applicant(randomProgram, randomLocation));
        }

        return applicants;
    }
}
