package store.dmario24.dmarioweb.question;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer>{

    Question findBySubject(String subject);

    Question findByContent(String content);

    Question findBySubjectAndContent(String subject, String content);

    Question findByContentAndSubject(String content, String subject);

    Question findByContentOrSubject(String content, String subject);

    List<Question> findBySubjectLike(String subject);
}
