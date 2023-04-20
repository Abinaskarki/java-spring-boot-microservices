package com.example.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.codec.ClientCodecConfigurer;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilderFactory;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrixDashboard
public class MovieCatalogServiceApplication {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(){
/*		HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		httpComponentsClientHttpRequestFactory.setConnectTimeout(3000);
		return new RestTemplate(httpComponentsClientHttpRequestFactory);*/

		return  new RestTemplate();
	}

	@Bean
	public WebClient.Builder getWebClientBuilder(){
		return new WebClient.Builder() {
			@Override
			public WebClient.Builder baseUrl(String baseUrl) {
				return null;
			}

			@Override
			public WebClient.Builder defaultUriVariables(Map<String, ?> defaultUriVariables) {
				return null;
			}

			@Override
			public WebClient.Builder uriBuilderFactory(UriBuilderFactory uriBuilderFactory) {
				return null;
			}

			@Override
			public WebClient.Builder defaultHeader(String header, String... values) {
				return null;
			}

			@Override
			public WebClient.Builder defaultHeaders(Consumer<HttpHeaders> headersConsumer) {
				return null;
			}

			@Override
			public WebClient.Builder defaultCookie(String cookie, String... values) {
				return null;
			}

			@Override
			public WebClient.Builder defaultCookies(Consumer<MultiValueMap<String, String>> cookiesConsumer) {
				return null;
			}

			@Override
			public WebClient.Builder defaultRequest(Consumer<WebClient.RequestHeadersSpec<?>> defaultRequest) {
				return null;
			}

			@Override
			public WebClient.Builder filter(ExchangeFilterFunction filter) {
				return null;
			}

			@Override
			public WebClient.Builder filters(Consumer<List<ExchangeFilterFunction>> filtersConsumer) {
				return null;
			}

			@Override
			public WebClient.Builder clientConnector(ClientHttpConnector connector) {
				return null;
			}

			@Override
			public WebClient.Builder codecs(Consumer<ClientCodecConfigurer> configurer) {
				return null;
			}

			@Override
			public WebClient.Builder exchangeStrategies(ExchangeStrategies strategies) {
				return null;
			}

			@Override
			public WebClient.Builder exchangeStrategies(Consumer<ExchangeStrategies.Builder> configurer) {
				return null;
			}

			@Override
			public WebClient.Builder exchangeFunction(ExchangeFunction exchangeFunction) {
				return null;
			}

			@Override
			public WebClient.Builder apply(Consumer<WebClient.Builder> builderConsumer) {
				return null;
			}

			@Override
			public WebClient.Builder clone() {
				return null;
			}

			@Override
			public WebClient build() {
				return null;
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}

}