import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Data
public class ScheduledIssue {

    private List<Integer> issueIds;


    public void addIssueId(Integer issueId) {
        if (Objects.isNull(issueIds)) {
            issueIds = new ArrayList<>();
        }
        issueIds.add(issueId);
    }

}
