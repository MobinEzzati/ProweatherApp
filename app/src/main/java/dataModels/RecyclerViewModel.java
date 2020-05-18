package dataModels;

public class RecyclerViewModel {

  private String temp ;
  private String cityName ;
  private String country ;


    public RecyclerViewModel(String temp, String cityName, String country) {
        this.temp = temp;
        this.cityName = cityName;
        this.country = country;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
