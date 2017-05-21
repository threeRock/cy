package io.jianxun.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.jianxun.source.repository.ERPMedicamentBatchRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CyCommonApplicationTests {

	@Autowired
	private ERPMedicamentBatchRepository eRPMedicamentBatchRepository;

	@Test
	public void contextLoads() {
		assertThat(eRPMedicamentBatchRepository).isNotNull();
	}

}
