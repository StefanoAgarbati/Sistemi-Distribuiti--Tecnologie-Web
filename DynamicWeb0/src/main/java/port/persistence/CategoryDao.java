package port.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import model.Category;

public class CategoryDao {

	private static String table = "category";
	private static String categoryId = "categoryId";

	public boolean createNewcategory(Category aCategory) {
		Connection conn = DbSupport.getConnection();
		int res = 0;
		try {

			Statement s = conn.createStatement();
			res = s.executeUpdate(
					this.newCategoryQuery(aCategory.getId(), aCategory.getName(), aCategory.getOwnerId()));

		} catch (Exception e) {

		}
		return res != 0;
	}

	public boolean updateCategory(Category aCategory) {
		Connection conn = DbSupport.getConnection();
		try {
			Statement s = conn.createStatement();
			return s.executeUpdate(this.updateCategoryQuery(aCategory)) != 0;
		} catch (Exception e) {

		}
		return false;
	}

	public boolean hasCategory(String name) {
		Connection conn = DbSupport.getConnection();
		int count = 0;
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(this.findByNameQuery(name));

			while (rs.next()) {
				count++;
			}
		} catch (Exception e) {

		}
		System.out.println("Count: " + count);
		return count != 0;
	}

	public Category findById(String id) {
		Category aCategory = null;
		Connection conn = DbSupport.getConnection();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(this.findByIdQuery(id));
			if (rs.next()) {
				String cid = rs.getString(1);
				String cname = rs.getString(2);
				String ownerId = rs.getString(3);
				aCategory = Category.create(cid, cname, ownerId);
			}
		} catch (Exception e) {

		}
		return aCategory;
	}

	public Collection<Category> getAllCategoriesByOwner(String ownerId) {
		Connection conn = DbSupport.getConnection();
		Collection<Category> categories = new ArrayList<>();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(this.allCategoriesQuery(ownerId));
			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String owId = rs.getString(3);
				Category category = Category.create(id, name, owId);
				categories.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}

	private String allCategoriesQuery(String ownerId) {
		String sql = "SELECT * FROM category where ownerId='" + ownerId + "'";
		return sql;
	}

	private String updateCategoryQuery(Category aCategory) {
		String sql = "UPDATE category SET categoryName = 'cname' WHERE categoryId = 'id'";
		sql = sql.replace("cname", aCategory.getName()).replace("id", "" + aCategory.getId());
		return sql;
	}

	private String findByIdQuery(String id) {
		return "select * from category where categoryId='" + id + "'";
	}

	public String newCategoryQuery(String id, String name, String ownerId) {
		String sql = "insert into category(categoryId, categoryName, ownerId) values('id', 'name', 'ownerId');";
		sql = sql.replace("id", id).replace("name", name).replace("ownerId", ownerId);
		return sql;
	}

	private String findByNameQuery(String name) {
		return "select * from category where categoryName=" + "'" + name + "'";
	}

	public static void main(String[] args) {
		CategoryDao dao = new CategoryDao();
		Category c1 = Category.of(IdGenerator.generateId(), "Generic");
		Category c2 = Category.of(IdGenerator.generateId(), "Math");
		Category c3 = Category.of(IdGenerator.generateId(), "Physics");

		dao.createNewcategory(c1);
		dao.createNewcategory(c2);
		dao.createNewcategory(c3);

	}
}
