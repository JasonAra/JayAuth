# JayAuth
Java rest authentication service

you just need to import it into your Spring Config

and call it in your class as:

```
    @Autowired
    private TokenService tokenService;

```

## .addObject
when a customer or user successfully authenticated this method is creating and return a unique token.
* by default token expier time is 30 minutes but you can set diffrent integer value



## .isTokenValid




## .getObject




## .removeObject