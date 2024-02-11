package projects.collection.algorithms;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;


public class StudentGradeBookImpl implements StudentGradeBook {

    private Map<Student, Map<String, BigDecimal>> map;

    public StudentGradeBookImpl() {
        map = new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int firstNames = o1.firstName().compareToIgnoreCase(o2.firstName());
                if (firstNames == 0) {
                    int lastNames = o1.lastName().compareToIgnoreCase(o2.lastName());
                    if (lastNames == 0) {
                        return o1.group().compareTo(o2.group());
                    }
                    return lastNames;
                }
                return firstNames;
            }
        });
    }

    static BigDecimal getAvgGrade(List<BigDecimal> grades) {
        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal bd : grades) {
            sum = sum.add(bd); // Update sum with the result of addition
        }
        return sum.divide(BigDecimal.valueOf(grades.size()), RoundingMode.CEILING);
    }

    @Override
    public boolean addEntryOfStudent(Student student, String discipline, BigDecimal grade) {
        Map<String, BigDecimal> studentGrades = map.get(student);
        if (studentGrades == null) {
            studentGrades = new TreeMap<>();
            map.put(student, studentGrades);
        }
        if (studentGrades.containsKey(discipline)) {
            return false;
        }
        studentGrades.put(discipline, grade);
        return true;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Comparator<Student> getComparator() {
        return new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int firstNames = o1.firstName().compareToIgnoreCase(o2.firstName());
                if (firstNames == 0) {
                    int lastNames = o1.lastName().compareToIgnoreCase(o2.lastName());
                    if (lastNames == 0) {
                        return o1.group().compareTo(o2.group());
                    }
                    return lastNames;
                }
                return firstNames;
            }
        };
    }

    @Override
    public List<String> getStudentsByDiscipline(String discipline) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<Student, Map<String, BigDecimal>> entry : map.entrySet()) {
            for (Map.Entry<String, BigDecimal> studentEntry : entry.getValue().entrySet()) {
                if (studentEntry.getKey().equalsIgnoreCase(discipline)) {
                    String studentDetails = entry.getKey().lastName() + "_" + entry.getKey().firstName() + ": " + studentEntry.getValue();
                    result.add(studentDetails);
                }
            }
        }
        return result;
    }

    @Override
    public Map<Student, Map<String, BigDecimal>> removeStudentsByGrade(BigDecimal grade) {
        Map<Student, Map<String, BigDecimal>> result = new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int firstNames = o1.firstName().compareToIgnoreCase(o2.firstName());
                if (firstNames == 0) {
                    int lastNames = o1.lastName().compareToIgnoreCase(o2.lastName());
                    if (lastNames == 0) {
                        return o1.group().compareTo(o2.group());
                    }
                    return lastNames;
                }
                return firstNames;
            }
        });
        for (Map.Entry<Student, Map<String, BigDecimal>> entry : map.entrySet()) {
            Student student = entry.getKey();
            Map<String, BigDecimal> grades = entry.getValue();
            boolean allGradesAboveThreshold = true;
            for (BigDecimal studentGrade : grades.values()) {
                if (studentGrade.compareTo(grade) <= 0) {
                    allGradesAboveThreshold = false;
                    break;
                }
            }
            if (allGradesAboveThreshold) {
                result.put(student, grades);
            }
        }
        map = result;
        return result;
    }

    @Override
    public Map<BigDecimal, List<Student>> getAndSortAllStudents() {
        Map<BigDecimal, List<Student>> result = new TreeMap<>();
        for (Map.Entry<Student, Map<String, BigDecimal>> entry : map.entrySet()) {
            BigDecimal avgGrade = getAvgGrade(new ArrayList<>(entry.getValue().values()));
            List<Student> students = result.getOrDefault(avgGrade, new ArrayList<>());
            students.add(entry.getKey());
            result.put(avgGrade, students);
        }
        return result;
    }
}
