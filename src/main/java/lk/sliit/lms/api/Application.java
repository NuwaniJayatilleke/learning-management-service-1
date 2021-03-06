package lk.sliit.lms.api;

import lk.sliit.lms.api.dto.AssignmentDTO;
import lk.sliit.lms.api.models.*;
import lk.sliit.lms.api.repositories.*;
import lk.sliit.lms.api.services.AssignmentService;
import lk.sliit.lms.api.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

/**
 * Initializing a spring boot application
 * <p>
 * Created by dinukshakandasamanage on 9/21/17.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    QuizService quizService;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    QuizMarkRepository quizMarkRepository;

    @Autowired
    AnsweredQuestionRepository answeredQuestionRepository;
    @Autowired
    AssignmentService assignmentService;

    @Autowired
    StudentAssignmentRepository studentAssignmentRepository;

    @Override
    public void run(String... strings) throws Exception {

        Course course = new Course();
        course.setTitle("IT150");
        course.setDescription("Software arch");
        Student student = new Student();
        student.setName("Test Student");
        Student student2 = new Student();
        student2.setName("Jonathan");
        studentRepository.save(student2);
        course.getStudents().add(studentRepository.save(student));


        Course course2 = new Course();
        course2.setName("Software Engineering I");

        courseRepository.save(course);

        Course course3 = new Course();
        course3.setName("Software Engineering II");
        courseRepository.save(course2);

        Course course4 = new Course();
        course4.setName("Case Studies in Software Engineering");
        courseRepository.save(course3);

        Course course5 = new Course();
        course5.setName("Software Project Management");
        courseRepository.save(course4);

        Quiz quiz = new Quiz();
        quiz.setCourse(courseRepository.findOne(1L));
        quiz = quizRepository.save(quiz);

        Question question = new Question();
        question.addQuestion("Test Answer 1");
        question.addQuestion("Test Answer 2");
        question.addQuestion("Test Answer 3");
        question.addQuestion("Test Answer 4");

        question.setQuestion("what is the answer?");
        question.setCorrectAnswer("Test Answer 4");

        question.setQuiz(quiz);

        question = questionRepository.save(question);

        quiz.addQuestion(question);
        quizRepository.save(quiz);

        Question question1 = new Question();
        question1.addQuestion("Test Answer 1");
        question1.addQuestion("Test Answer 2");
        question1.addQuestion("Test Answer 3");
        question1.addQuestion("Test Answer 4");

        question1.setQuestion("what is the answer?");
        question1.setCorrectAnswer("Test Answer 1");

        Question question2 = new Question();
        question2.addQuestion("Test Answer 1");
        question2.addQuestion("Test Answer 2");
        question2.addQuestion("Test Answer 3");
        question2.addQuestion("Test Answer 4");

        question2.setQuestion("what is the answer?");
        question2.setCorrectAnswer("Test Answer 1");

        Question question3 = new Question();
        question3.addQuestion("Test Answer 1");
        question3.addQuestion("Test Answer 2");
        question3.addQuestion("Test Answer 3");
        question3.addQuestion("Test Answer 4");

        question3.setQuestion("what is the answer?");
        question3.setCorrectAnswer("Test Answer 1");

        Question question4 = new Question();
        question4.addQuestion("Test Answer 1");
        question4.addQuestion("Test Answer 2");
        question4.addQuestion("Test Answer 3");
        question4.addQuestion("Test Answer 4");

        question4.setQuestion("what is the answer?");
        question4.setCorrectAnswer("Test Answer 1");

        Question question5 = new Question();
        question5.addQuestion("Test Answer 1");
        question5.addQuestion("Test Answer 2");
        question5.addQuestion("Test Answer 3");
        question5.addQuestion("Test Answer 4");

        question5.setQuestion("what is the answer?");
        question5.setCorrectAnswer("Test Answer 1");

        Question question6 = new Question();
        question6.addQuestion("Test Answer 1");
        question6.addQuestion("Test Answer 2");
        question6.addQuestion("Test Answer 3");
        question6.addQuestion("Test Answer 4");

        question6.setQuestion("what is the answer?");
        question6.setCorrectAnswer("Test Answer 1");

        Question question7 = new Question();
        question7.addQuestion("Test Answer 1");
        question7.addQuestion("Test Answer 2");
        question7.addQuestion("Test Answer 3");
        question7.addQuestion("Test Answer 4");

        question7.setQuestion("what is the answer?");
        question7.setCorrectAnswer("Test Answer 1");

        Question question8 = new Question();
        question8.addQuestion("Test Answer 1");
        question8.addQuestion("Test Answer 2");
        question8.addQuestion("Test Answer 3");
        question8.addQuestion("Test Answer 4");

        question8.setQuestion("what is the answer?");
        question8.setCorrectAnswer("Test Answer 1");

        Question question9 = new Question();
        question9.addQuestion("Test Answer 1");
        question9.addQuestion("Test Answer 2");
        question9.addQuestion("Test Answer 3");
        question9.addQuestion("Test Answer 4");

        question9.setQuestion("what is the answer?");
        question9.setCorrectAnswer("Test Answer 1");

        question1.setQuiz(quiz);
        question1 = questionRepository.save(question1);

        question2.setQuiz(quiz);
        question2 = questionRepository.save(question2);

        question3.setQuiz(quiz);
        question3 = questionRepository.save(question3);

        question4.setQuiz(quiz);
        question4 = questionRepository.save(question4);

        question5.setQuiz(quiz);
        question5 = questionRepository.save(question5);

        question6.setQuiz(quiz);
        question6 = questionRepository.save(question6);

        question7.setQuiz(quiz);
        question7 = questionRepository.save(question7);

        question8.setQuiz(quiz);
        question8 = questionRepository.save(question8);

        question9.setQuiz(quiz);
        question9 = questionRepository.save(question9);


        quiz.addQuestion(question1);
        quizRepository.save(quiz);

        List<Question> Q1 = new ArrayList<>();

        Q1.add(question);
        Q1.add(question1);

        List<AnsweredQuestion> Q2 = new ArrayList<>();

        AnsweredQuestion aq = new AnsweredQuestion(question,"Test Answer 1");
        answeredQuestionRepository.save(aq);
        AnsweredQuestion aq1 = new AnsweredQuestion(question1,"Test Answer 2");
        answeredQuestionRepository.save(aq1);
        AnsweredQuestion aq2 = new AnsweredQuestion(question2,"Test Answer 3");
        answeredQuestionRepository.save(aq2);
        AnsweredQuestion aq3 = new AnsweredQuestion(question3,"Test Answer 1");
        answeredQuestionRepository.save(aq3);

        Q2.add(aq);
        Q2.add(aq1);
        Q2.add(aq2);
        Q2.add(aq3);

        QuizMark quizMark1 = new QuizMark();
        quizMark1.setQuiz(quiz);
        quizMark1.setStudent(student2);
        quizMark1.setMarks(1);
        quizMark1.setAnsweredQuestions(Q2);
        quizMarkRepository.save(quizMark1);

        AssignmentDTO assignment = new AssignmentDTO();
        assignment.setCourseId(1L);
        assignment.setDescription("test assignment");
        Assignment assignment1 = assignmentService.addAssignment(assignment);

        Student student1 = new Student();
        student1.setName("Dinu");

        StudentAssignment studentAssignment = new StudentAssignment();
        studentAssignment.setStudent( studentRepository.save(student1));
        studentAssignment.setAssignment(assignment1);

        studentAssignment = studentAssignmentRepository.save(studentAssignment);

        Set<StudentAssignment> studentAssignments = new HashSet<StudentAssignment>(Arrays.asList(studentAssignment));

        student1.setStudentAssignment(studentAssignments);

        studentRepository.save(student1);


    }
}


