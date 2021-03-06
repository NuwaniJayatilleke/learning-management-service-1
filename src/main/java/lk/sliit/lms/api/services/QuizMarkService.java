package lk.sliit.lms.api.services;

import lk.sliit.lms.api.dto.AnsweredQuestionDTO;
import lk.sliit.lms.api.dto.QuizMarkDTO;
import lk.sliit.lms.api.models.*;
import lk.sliit.lms.api.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by kashifroshen on 10/21/17.
 */
@Service
public class QuizMarkService {
    @Autowired
    QuizMarkRepository quizMarkRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnsweredQuestionRepository answeredQuestionRepository;

    QuizMark quizMark;

    public QuizMark addMarks(QuizMarkDTO quizMarkDTO){

        QuizMark quizMark = new QuizMark();

        Student student = studentRepository.findOne(quizMarkDTO.getStudent());
        Quiz quiz = quizRepository.findOne(quizMarkDTO.getQuiz());

       List<Question> questions = new ArrayList<>();
       List<AnsweredQuestion> answeredQuestions = new ArrayList<>();
       AnsweredQuestion answeredQuestion;

        Long questionId;
        String selectedAnswer;

        for(int i=0;i<quizMarkDTO.getAnsweredQuestions().size();i++) {
            questionId = quizMarkDTO.getAnsweredQuestions().get(i).getQuestion();
            selectedAnswer = quizMarkDTO.getAnsweredQuestions().get(i).getSelectedAnswer();

            answeredQuestion = new AnsweredQuestion(questionRepository.findOne(questionId),selectedAnswer);
            answeredQuestion = answeredQuestionRepository.save(answeredQuestion);
            answeredQuestions.add(answeredQuestion);
        }

        quizMark.setMarks(quizMarkDTO.getMarks());
        quizMark.setStudent(student);
        quizMark.setQuiz(quiz);
        quizMark.setAnsweredQuestions(answeredQuestions);

        quizMark = quizMarkRepository.save(quizMark);

        return quizMark;

//        return quizMarkRepository.save(quizMark);
    }


    public QuizMark getMark(Long quizId,Long studentId){
        quizMark = new QuizMark();
        quizMarkRepository.findAll().forEach(quizM -> {
            if ((quizM.getQuiz().getqId() == quizId) && (quizM.getStudent().getsId() == studentId)) {
                quizMark = quizM;
            }
        });
        return quizMark;
    }


    public Student getQuizMark(QuizMarkDTO quizMarkDTO) {
        return studentRepository.findOne(quizMarkDTO.getStudent());
    }
}
