package in.ineuron.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.exception.AdminDataInsertionException;
import in.ineuron.exception.AdminDataNotFoundException;
import in.ineuron.model.Admin;
import in.ineuron.repo.AdminRepositiry;

@Service(value = "adminService")
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private AdminRepositiry adminRepo;

	@Override
	public String saveAdminData(Admin admin) {

		Integer id = null;
		Integer emailStatus = adminRepo.checkEmailIsAvailableOrNot(admin.getAmail());
		if (emailStatus == 0)
			id = adminRepo.save(admin).getAid();
		else
			return "Mail id has already choosen by another user";

		if (id != null)
			return "Admin Data is saved with id " + id;
		else
			throw new AdminDataInsertionException("Admin Data Insertion Failed");
	}

	@Override
	public Admin findAdminById(Integer id) {
		Optional<Admin> admin = adminRepo.findById(id);
		if (admin.isPresent())
			return admin.get();
		else
			throw new AdminDataNotFoundException("Admin info is not available for the given id:: " + id);
	}

	@Override
	public String updateAdminData(Admin admin) {
		Optional<Admin> adminInfo = adminRepo.findById(admin.getAid());
		if (adminInfo.isPresent()) {

			Admin adminPreviousData = adminInfo.get();

			if (admin.getAname() != null)
				adminPreviousData.setAname(admin.getAname());
			if (admin.getGender() != null)
				adminPreviousData.setGender(admin.getGender());
			if (admin.getPassword() != null)
				adminPreviousData.setPassword(admin.getPassword());

			Integer id = adminRepo.save(adminPreviousData).getAid();
			return "Admin Data is Updated for id " + id;
		} else {
			throw new AdminDataNotFoundException("Admin info is not available for the id:: " + admin.getAid());
		}
	}

	@Override
	public String deleteAdminDataByID(Integer aid) {
		Optional<Admin> adminInfo = adminRepo.findById(aid);
		if (adminInfo.isPresent()) {
			adminRepo.delete(adminInfo.get());
			return "Admin Data is deleted for id " + aid;
		} else {
			throw new AdminDataNotFoundException("Admin info is not available with the id:: " + aid);
		}
	}

	@Override
	public Admin findAdminByMail(String mail) {
		Admin admin = adminRepo.findByAmail(mail);
		if (admin != null)
			return admin;
		else
			throw new AdminDataNotFoundException("Admin info is not available for the given mail:: " + mail);
	}

}
