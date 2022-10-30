package com.comohogar.benefit.domain.interfaces.repositories;

import java.io.IOException;
import java.util.Optional;

import com.comohogar.benefit.domain.entities.SKFormat;

public interface ISKFormatRepository {

	Optional<SKFormat> getSKFormat() throws IOException;


}
