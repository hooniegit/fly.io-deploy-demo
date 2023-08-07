package store.dmario24.dmarioweb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import store.dmario24.dmarioweb.answer.Answer;
import store.dmario24.dmarioweb.answer.AnswerRepository;
import store.dmario24.dmarioweb.question.Question;
import store.dmario24.dmarioweb.question.QuestionRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DmariowebApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Test
	void testJpaQuestion() {
		Question q1 = new Question();
		q1.setSubject("제목 테스트 1");
		q1.setContent("본문 블라블라블라~~~~");
		q1.setCreateDate(LocalDateTime.now());
		questionRepository.save(q1);
	}

	@Test
	void testJpaAnswer() {
		Optional<Question> op = questionRepository.findById(1);
		if(op.isPresent()){
			Question q1 = op.get();

			Answer a = new Answer();
			a.setQuestion(q1);
			a.setContent("1번 답변");
			a.setCreateDate(LocalDateTime.now());

			answerRepository.save(a);
		}
	}

	@Test
	void testJpaUpdateQuestion(){
		Optional<Question> op = questionRepository.findById(5);
		assertTrue(op.isPresent());

		Question q = op.get();
		q.setSubject("제목 테스트 5");

		questionRepository.save(q);
	}

	@Test
	void testJpaDeleteQuestion(){
		Optional<Question> op = questionRepository.findById(4);
		assertTrue(op.isPresent());

		Question q = op.get();

		questionRepository.delete(q);
	}

	@Test
	@Transactional
	@Rollback(value = true)
	void 테스트_메소드이름_기반_쿼리() {
		// given
		String subject = "테스트용제목";
		String content = "테스트용본문";
		Question q = new Question();
		q.setSubject(subject);
		q.setContent(content);
		q.setCreateDate(LocalDateTime.now());
		questionRepository.save(q);

		Question q2 = new Question();
		q2.setSubject(subject);
		q2.setContent(content);
		q2.setCreateDate(LocalDateTime.now());
		questionRepository.save(q2);

		// when
		Question r1 = questionRepository.findBySubject(subject);
		Question r2 = questionRepository.findByContent(content);
		Question r3 = questionRepository.findBySubjectAndContent(subject, content);
		Question r4 = questionRepository.findByContentAndSubject(content, subject);
		Question r5 = questionRepository.findByContentOrSubject(content, "~~~~");
		List<Question> r6 = questionRepository.findBySubjectLike("%스트용제%");

		// then
		assertEquals(subject, r1.getSubject());
		assertEquals(content, r1.getContent());

		assertEquals(subject, r2.getSubject());
		assertEquals(content, r2.getContent());

		assertEquals(subject, r3.getSubject());
		assertEquals(content, r3.getContent());

		assertEquals(subject, r4.getSubject());
		assertEquals(content, r4.getContent());

		assertEquals(subject, r5.getSubject());
		assertEquals(content, r5.getContent());

		assertEquals(subject, r6.get(0).getSubject());
		assertEquals(content, r6.get(0).getContent());

	}

}
