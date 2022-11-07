using Herlivre_api.Models;
using Microsoft.EntityFrameworkCore;

namespace herlivre_api.Models
{
    public class GeralDbContext : DbContext
    {
        public GeralDbContext(DbContextOptions<GeralDbContext> options)
        : base(options)
        { }

        public DbSet<Cargo> Cargos { get; set; }
        public DbSet<Cidade> Cidades { get; set; }
        public DbSet<Comprovante> Comprovantes { get; set; }
        public DbSet<Hotel> Hoteis { get; set; }
        public DbSet<Pacote> Pacotes { get; set; }
        public DbSet<Quarto> Quartos { get; set; }
        public DbSet<RegistroAluguelQuarto> RegistroAluguelQuartos { get; set; }
        public DbSet<Usuario> Usuarios { get; set; }
        public DbSet<Voo> Voos { get; set; }
    }
}
