package io.jianxun.extend.service.business;

import java.util.List;

import org.assertj.core.util.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.jianxun.extend.domain.business.Depart;
import io.jianxun.extend.service.AbstractBaseService;

@Service
public class DepartService extends AbstractBaseService<Depart> {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	public static final String ROOT_DEPART_NAME = "长江药业";

	/**
	 * 创建机构根目录
	 * 
	 * @return
	 */
	@Transactional(readOnly = false)
	public Depart initRoot() {
		Depart depart;
		if (this.repository.count() == 0) {
			depart = new Depart();
			depart.setName(ROOT_DEPART_NAME);
			return this.save(depart);
		}
		return this.repository.findActiveOne(1L);

	}

	public boolean validateNameUnique(String name, Long id) {
		return 0 == countActiveAll(DepartPredicates.nameAndIdNotPredicate(name, id));
	}

	/**
	 * 获取下级机构
	 * 
	 * @param root
	 * @return
	 */
	public void getSubDeparts(List<Depart> container, Depart root) {
		List<Depart> ds = this.repository.findActiveAll(DepartPredicates.parentPredicate(root),
				new Sort(Depart.ID_NAME));
		if (!ds.isEmpty())
			container.addAll(ds);
		for (Depart depart : ds) {
			getSubDeparts(container, depart);
		}
	}

	public List<Depart> getSubDeparts(Depart depart) {
		List<Depart> result = Lists.newArrayList();
		getSubDeparts(result, depart);
		return result;
	}

}
