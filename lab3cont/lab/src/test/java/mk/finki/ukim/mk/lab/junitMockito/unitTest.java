package mk.finki.ukim.mk.lab.junitMockito;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.ShoppingCart;
import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.repository.BalloonRepository;
import mk.finki.ukim.mk.lab.repository.ManufacturerRepository;
import mk.finki.ukim.mk.lab.repository.jpa.UserReposotory;
import mk.finki.ukim.mk.lab.service.ShoppingCartService;
import mk.finki.ukim.mk.lab.service.impl.BalloonServiceImpl;
import mk.finki.ukim.mk.lab.service.impl.ManufacturerServiceImpl;
import mk.finki.ukim.mk.lab.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.List;

import static java.awt.SystemColor.text;

@RunWith(MockitoJUnitRunner.class)
public class unitTest {

    @Mock
    private BalloonRepository balloonRepository;
    @Mock
    private ManufacturerRepository manufacturerRepository;

    private BalloonServiceImpl balloonService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        Balloon balloon = new Balloon("name","description");

        Mockito.when(this.balloonRepository.findAllBaloons()).thenReturn(List.of(new Balloon[]{new Balloon("test", "test")}));

        this.balloonService = Mockito.spy(new BalloonServiceImpl(this.balloonRepository,this.manufacturerRepository));
    }

    @Test
    public void testSuccess(){

        Assert.assertNotNull("list is null",this.balloonService.listAll());
    }
}
