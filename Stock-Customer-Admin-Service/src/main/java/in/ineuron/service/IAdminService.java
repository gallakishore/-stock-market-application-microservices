package in.ineuron.service;

import in.ineuron.model.Admin;

public interface IAdminService {

	public String saveAdminData(Admin admin);

	public Admin findAdminById(Integer id);

	public Admin findAdminByMail(String mail);

	public String updateAdminData(Admin admin);

	public String deleteAdminDataByID(Integer aid);

}
