package model.gpod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class WishlistGpod {
    private String userId; //email

    private List<FavouritesGpod> favourites= new ArrayList<>();

    public WishlistGpod() {
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<FavouritesGpod> getFavourites() {
        return favourites;
    }

    public void setFavourites(List<FavouritesGpod> favourites) {
        this.favourites = favourites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WishlistGpod that = (WishlistGpod) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(favourites, that.favourites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, favourites);
    }

    @Override
    public String toString() {
        return "WishlistGpod{" +
                "userId='" + userId + '\'' +
                ", favourites=" + favourites +
                '}';
    }
}
