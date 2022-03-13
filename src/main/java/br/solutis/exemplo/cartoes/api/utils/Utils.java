package br.solutis.exemplo.cartoes.api.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import br.solutis.exemplo.cartoes.api.dto.CartaoDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Utils {

	public static LocalDate formatarStringToDate(String data) {
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
		LocalDate dataFormatada = null;
		try {
			dataFormatada = formater.parse(data).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return dataFormatada;
	}

	public static String formatarDateToString(LocalDate data) {
		String dataFormatada = data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		return dataFormatada;
	}

	public static boolean verificarCartaoDto(CartaoDto cartao) {
		return !zapNuloOuzapVazio(cartao.getNumeroCartao()) && cartao.getNumeroCartao().length() == 9
				&& !zapNuloOuzapVazio(cartao.getSenha());
	}

	private static boolean zapNuloOuzapVazio(String zap) {
		return zap == null || zap.isEmpty();
	}

}
