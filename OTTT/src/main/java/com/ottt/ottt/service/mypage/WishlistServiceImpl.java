package com.ottt.ottt.service.mypage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ottt.ottt.dao.mypage.WishlistDao;
import com.ottt.ottt.domain.SearchItem;
import com.ottt.ottt.dto.WishlistDTO;

@Service
public class WishlistServiceImpl implements WishlistService {
	
	@Autowired
	WishlistDao wishlistDao;

	@Override
	public List<WishlistDTO> getWishlist(Integer user_no) throws Exception {
		return wishlistDao.wishSelect(user_no);
	}

	@Override
	public int wishCheck(Integer user_no, Integer content_no) throws Exception {
		return wishlistDao.wishInsert(user_no, content_no);
	}

	@Override
	public int wishCancel(Integer user_no, Integer content_no) throws Exception {
		return wishlistDao.wishDelete(user_no, content_no);
	}

	@Override
	public List<WishlistDTO> getMyWishlist(SearchItem sc) throws Exception {
		return wishlistDao.myWishListSelect(sc);
	}

	@Override
	public int myWishlistCnt(SearchItem sc) throws Exception {
		return wishlistDao.myWishListCnt(sc);
	}

}
