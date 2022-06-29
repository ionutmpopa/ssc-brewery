package guru.sfg.brewery.security.perms.beerorder;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasAuthority('beer.delete')")
public @interface BeerOrderDeletePermission {
}
