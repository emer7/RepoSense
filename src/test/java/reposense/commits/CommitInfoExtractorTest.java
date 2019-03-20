package reposense.commits;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import reposense.commits.model.CommitInfo;
import reposense.template.GitTestTemplate;
import reposense.util.TestUtil;

public class CommitInfoExtractorTest extends GitTestTemplate {

    @Test
    public void withContentTest() {
        List<CommitInfo> commits = CommitInfoExtractor.extractCommitInfos(config);
        Assert.assertFalse(commits.isEmpty());
    }

    @Test
    public void withoutContentTest() {
        Date sinceDate = TestUtil.getDate(2050, Calendar.JANUARY, 1);

        List<CommitInfo> commits = CommitInfoExtractor.extractCommitInfos(config, sinceDate, null);
        Assert.assertTrue(commits.isEmpty());
    }
}
