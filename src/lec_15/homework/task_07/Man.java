package lec_15.homework.task_07;

/*Сделать класс Man у которого 3 поля - имя, фамилия, тел.номер.
 * Сделать конструкторы:
 * 1.с параметрами имя тел. номер,
 * 2. с параметрами имя, фамилия тел. номер.
 * 3. с параметрами имя, фамилия.
 * Конструктора без параметров быть не должно. Избежать дублирования кода
 */

 public class Man
{
	private String firstName;
	private String lastName;
	private int phoneNumber;

	public Man(String firstName, String lastName, int phoneNumber)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}
	
	public Man(String firstName, int phoneNumber)
	{
		this(firstName, null, phoneNumber);
	}
	
	public Man(String firstName, String lastName)
	{
		this(firstName, lastName, 0);
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setPhoneNumber(int phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	public int getPhoneNumber()
	{
		return phoneNumber;
	}}
