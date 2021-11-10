package cn.binarywang.wx.miniapp.api.impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.shortlink.GenerateShortLinkRequest;
import cn.binarywang.wx.miniapp.bean.urllink.GenerateUrlLinkRequest;
import cn.binarywang.wx.miniapp.test.ApiTestModule;
import com.google.inject.Inject;
import me.chanjar.weixin.common.error.WxErrorException;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

@Test
@Guice(modules = ApiTestModule.class)
public class WxMaLinkServiceImplTest {
  @Inject
  private WxMaService wxMaService;

  @Test
  public void testGenerateUrlLink() throws WxErrorException {
    String url = this.wxMaService.getLinkService().generateUrlLink(GenerateUrlLinkRequest.builder()
      .path("pages/tabBar/home/home")
      .build());

    System.out.println(url);
  }

  @Test
  public void testGenerateShortLink() throws WxErrorException {
    final String generate = this.wxMaService.getLinkService()
      .generateShortLink(GenerateShortLinkRequest.builder().
        pageUrl("pages/productView/editPhone/editPhone?id=31832")
        .pageTitle("productView")
        .isPermanent(false).build());
    System.out.println("generate:");
    System.out.println(generate);
  }
}
