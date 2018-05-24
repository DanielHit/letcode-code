mport java.io.Serializable;

/**
 *  * @author Daniel
 *   * @date 22/05/2018
 *    */

public class TestMo implements Serializable {
	    private static final long serialVersionUID = -3245478690496182643L;

	        private String name;
		    private int age;

		        public String getName() {
				        return name;
					    }

			    public void setName(String name) {
				            this.name = name;
					        }

			        public int getAge() {
					        return age;
						    }

				    public void setAge(int age) {
					            this.age = age;
						        }
}

