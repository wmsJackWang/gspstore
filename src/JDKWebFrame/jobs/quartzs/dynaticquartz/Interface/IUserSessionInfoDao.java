package JDKWebFrame.jobs.quartzs.dynaticquartz.Interface;

import com.jeecg.pageModel.User;

public interface IUserSessionInfoDao {


	public void setUserInfo(User user);

	public User getUserInfo();
}
