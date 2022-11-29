package oop_lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Runner {

    static List<Can> courses = new ArrayList<>();

    public static void main(String[] args) {

        Can course1 = new Can("fall", "Core Java", 85, 350);
        Can course2 = new Can("spring", "Advanced Java", 79, 154);
        Can course3 = new Can("spring", "Selenium", 92, 196);
        Can course4 = new Can("fall", "SDLC", 94, 350);

        //Add them into a list
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);

        //Check if all average scores are less than 98
        allAverageScoresLess98(courses);

        allCourseNamesContainDay(courses);

        //Check if any number of students is 154
        anyStdNumber154(courses);

        //Check if any season is Winter
        anySeasonWinter(courses);

        //Check if no number of students is 100
        noStdNumber100(courses);

        //Sort the elements in natural order according to the average score
        System.out.print("\nNot ortalamasina gore sirali liste: ");
        elSortAccordingAvrgScore(courses);

        System.out.println();
        //Sort the elements in reverse order according to the number of students
        System.out.print("\nOgrenci sayisina gore tersten sirali liste: ");
        elReversSortAccordingNrStd(courses);

        System.out.println();
        //Sort the elements in reverse order according to the course name
        System.out.print("\nDers ismine gore tersten sirali liste: ");
        elReversSortAccordingCourseName(courses);
    }

    public static void allAverageScoresLess98(List<Can> courses) {
        System.out.println(courses.stream().
                allMatch(t -> t.getAverageScore() < 98) ? "Tum not ortalamalari 98'in altinda" : "98 veya uzerinde olan not ortalamalari var");
    }

    public static void allCourseNamesContainDay(List<Can> courses) {
        System.out.println(courses.stream().
                allMatch(t -> t.getCourseName().contains("Day")) ? "Tum ders isimleri 'Day' tabiri icermektedir" : "'Day' tabiri icermeyen dersler var");
    }

    public static void anyStdNumber154(List<Can> courses) {
        System.out.println(courses.stream().
                anyMatch(t -> t.getNumberOfStudents() == 154) ? "Ogrenci sayisi 154 olan dersler var" : "Ogrenci sayisi 154 olan hic ders yok");
    }

    public static void anySeasonWinter(List<Can> courses) {
        System.out.println(courses.stream().
                anyMatch(t -> t.getSeason().equalsIgnoreCase("winter")) ? "Donemi kis olan dersler mevcut" : "Donemi kis olan ders yok");
    }

    public static void noStdNumber100(List<Can> courses) {
        System.out.println(courses.stream().
                noneMatch(t -> t.getNumberOfStudents() == 100) ? "Ogrenci sayisi 100 olan ders bulunmamaktadir" : "Ogrenci sayisi 100 olan dersler mevcut");
    }

    public static void elSortAccordingAvrgScore(List<Can> courses) {
        courses.stream().
                sorted(Comparator.comparing(Can::getAverageScore)).
                forEach(t -> System.out.print(t));
    }

    public static void elReversSortAccordingNrStd(List<Can> courses) {
        courses.stream().
                sorted(Comparator.comparing(Can::getNumberOfStudents).reversed()).
                forEach(t -> System.out.print(t));
    }

    public static void elReversSortAccordingCourseName(List<Can> courses) {
        courses.stream().
                sorted(Comparator.comparing(Can::getCourseName).reversed()).
                forEach(t -> System.out.print(t));
    }
}
