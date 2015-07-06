import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Hans Peeter Tulmin on 1.07.2015.
 */

@Entity
public class PlainEntity extends PlainObject {

	@Override
	public String toString() {
		return  "bar: " + this.bar + " id: " + this.id + " name: " + this.name;
	}

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "bar")
	private String bar;

	@Column(name = "name")
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBar() {
		return bar;
	}

	public void setBar(String bar) {
		this.bar = bar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
