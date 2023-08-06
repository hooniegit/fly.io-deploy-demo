package kplc.resume;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ResumeApplicationTests {
	@Autowired
	private ResumepRepository resumepRepository;
	@Test
	void contextLoads() {
		Resumep resumep = new Resumep();
		resumep.setName("park");
		resumep.setBirthday("1900-01-01");
		resumep.setResume_inside("안녕하세요. 저는 박기범이라고 합니다.");
		resumepRepository.save(resumep);
	}

}
