package es.upm.miw.innoassessment.data.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import es.upm.miw.innoassessment.data.entities.AssessmentLine;
import es.upm.miw.innoassessment.data.entities.ModelItem;
import es.upm.miw.innoassessment.data.entities.Questionnarie;

public interface AssessmentLineDao extends JpaRepository<AssessmentLine, Integer>, AssessmentLineDaoExtended {

	List<AssessmentLine> findByModel(ModelItem modelItem);
	List<AssessmentLine> findByQuestionnarie(Questionnarie questionnarie);


}