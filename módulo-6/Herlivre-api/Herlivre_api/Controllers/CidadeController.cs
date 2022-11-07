using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using herlivre_api.Models;

namespace Herlivre_api.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class CidadeController : ControllerBase
    {
        private readonly GeralDbContext _context;

        public CidadeController(GeralDbContext context)
        {
            _context = context;
        }

        // GET: api/Cidade
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Cidade>>> GetCidades()
        {
            return await _context.Cidades.ToListAsync();
        }

        // GET: api/Cidade/5
        [HttpGet("{id}")]
        public async Task<ActionResult<Cidade>> GetCidade(long id)
        {
            var cidade = await _context.Cidades.FindAsync(id);

            if (cidade == null)
            {
                return NotFound();
            }

            return cidade;
        }

        // PUT: api/Cidade/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutCidade(long id, Cidade cidade)
        {
            if (id != cidade.Id)
            {
                return BadRequest();
            }

            _context.Entry(cidade).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!CidadeExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // POST: api/Cidade
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<Cidade>> PostCidade(Cidade cidade)
        {
            _context.Cidades.Add(cidade);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetCidade", new { id = cidade.Id }, cidade);
        }

        // DELETE: api/Cidade/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteCidade(long id)
        {
            var cidade = await _context.Cidades.FindAsync(id);
            if (cidade == null)
            {
                return NotFound();
            }

            _context.Cidades.Remove(cidade);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool CidadeExists(long id)
        {
            return _context.Cidades.Any(e => e.Id == id);
        }
    }
}
